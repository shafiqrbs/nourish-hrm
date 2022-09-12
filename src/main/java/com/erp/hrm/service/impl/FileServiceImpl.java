package com.erp.hrm.service.impl;

import com.erp.hrm.domain.*;
import com.erp.hrm.repository.DeviceRowDataTempRepository;
import com.erp.hrm.repository.DeviceRowUploadedDataRepository;
import com.erp.hrm.repository.attendance.AttendanceUploadFilesRepository;
import com.erp.hrm.repository.attendance.DailyAttendanceRepository;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.reports.DailyAttendanceReportRepository;
import com.erp.hrm.service.FileService;
import com.erp.hrm.util.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManagerFactory;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by WS on 04/08/2018.
 */
@Service
public class FileServiceImpl implements FileService {
    private long attFileId = 0;

    private DeviceRowUploadedDataRepository uploadedDataRepository;
    private DeviceRowDataTempRepository deviceRowDataTempRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    private AttendanceUploadFilesRepository attendanceUploadFilesRepository;

    private DailyAttendanceRepository dailyAttendanceRepository;
    private DailyAttendanceReportRepository attendanceReportRepository;

    private EntityManagerFactory emf;


    public FileServiceImpl(EntityManagerFactory emf, EmployeeInfoRepository employeeInfoRepository, AttendanceUploadFilesRepository attendanceUploadFilesRepository,
                           DeviceRowUploadedDataRepository uploadedDataRepository,DeviceRowDataTempRepository deviceRowDataTempRepository,
                           DailyAttendanceRepository dailyAttendanceRepository,
                           DailyAttendanceReportRepository attendanceReportRepository) {
        Assert.notNull(emf, "EntityManagerFactory must not be null");
        this.emf = emf;
        this.employeeInfoRepository = employeeInfoRepository;
        this.attendanceUploadFilesRepository = attendanceUploadFilesRepository;
        this.uploadedDataRepository = uploadedDataRepository;
        this.deviceRowDataTempRepository = deviceRowDataTempRepository;
        this.dailyAttendanceRepository = dailyAttendanceRepository;
        this.attendanceReportRepository = attendanceReportRepository;
    }

    @Override
    public ActionResult save(List<MultipartFile > files){
        ActionResult actionResult = new ActionResult();
        try {
            List<AttendanceUploadedFiles> uploadedFiles = new ArrayList<>();

            File directory = ErpUtils.getResourcdeDirectory(StaticName.FILE_UPLOADED_FOLDER );

            Thread t = new Thread(() -> {

                for (MultipartFile file: files) {
                    try {
                        byte[] bytes = file.getBytes();
                        Path path = Paths.get(directory.getAbsolutePath() + "/" + file.getOriginalFilename());
                        Files.write(path, bytes);

                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });
            t.start();

            for (MultipartFile file: files) {

                AttendanceUploadedFiles uploadedFileObj = attendanceUploadFilesRepository.getAttendanceFilesIfExists(file.getOriginalFilename(), file.getContentType());
                AttendanceUploadedFiles uploadedFile = new AttendanceUploadedFiles();
                if (uploadedFileObj == null) {
                    uploadedFile.setFileName(file.getOriginalFilename());
                    uploadedFile.setFileType(file.getContentType());
                    uploadedFile.setUploadedStatus("initial");
                } else {
                    if (uploadedFileObj.getUploadedStatus().contains("success")) {
                        uploadedFile.setFileName(file.getOriginalFilename());
                        uploadedFile.setFileType(file.getContentType());
                        uploadedFile.setUploadedStatus("rejected");
                        uploadedFile.setComments("This file already uploaded and confirmed.");
                    } else {
                        uploadedFile.setId(uploadedFileObj.getId());
                        uploadedFile.setFileName(uploadedFileObj.getFileName());
                        uploadedFile.setFileType(uploadedFileObj.getFileType());
                        uploadedFile.setUploadedStatus("initial");
                    }
                }

//                ByteArrayInputStream bis=new  ByteArrayInputStream(file.getBytes());
                long count = 0;
//                try(BufferedReader br=new BufferedReader(new InputStreamReader(bis))){
//                    count = (int) br.lines().count();
//                }

                uploadedFile.setFileSize(file.getSize());
                uploadedFile.setNoOfRows(count);
                uploadedFile.setUploadedFolderName(StaticName.FILE_UPLOADED_FOLDER);
                uploadedFile.setUploadedPathName(StaticName.FILE_UPLOADED_FOLDER + file.getOriginalFilename());
                uploadedFiles.add(uploadedFile);
            }


//            attendanceUploadFilesRepository.save(uploadedFiles);

            attendanceUploadFilesRepository.saveAll(uploadedFiles);
            
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Files saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setSuccessMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult uploadAllInitialAttendanceFile() {
        ActionResult actionResult = new ActionResult();
        try{

            Thread t = new Thread(() -> {
                List<AttendanceUploadedFiles> uploadedFiles = attendanceUploadFilesRepository.getAllUploadingInitialFiles();
                for (AttendanceUploadedFiles uploadedFileObj:uploadedFiles) {
                    try {
                        //Delete existing temp data before new upload
                        uploadedDataRepository.deleteAll();


                        File directory = ErpUtils.getResourcdeDirectory(StaticName.FILE_UPLOADED_FOLDER);

                        String fullPath = directory.getAbsolutePath() + "/" + uploadedFileObj.getFileName();
                        Path path = Paths.get(fullPath);

                        uploadedFileObj.setUploadedStatus("uploading");
                        attendanceUploadFilesRepository.save(uploadedFileObj);

                        String msg = readFile(path, uploadedFileObj.getId());
                        uploadedFileObj.setUploadedStatus(msg);
                        uploadedFileObj.setComments("file uploaded but process pending");
                        attendanceUploadFilesRepository.save(uploadedFileObj);
                    } catch (Exception e){
                        e.printStackTrace();

                        uploadedFileObj.setUploadedStatus("failed");
                        uploadedFileObj.setComments(e.getMessage().substring(0,e.getMessage().length() > 255 ? 255 : e.getMessage().length()));
                        attendanceUploadFilesRepository.save(uploadedFileObj);

                    }
                }

                //Attendance Process Start
                processAttendanceFile();
            });
            t.start();

            //return success message
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Upload Started");
        }
        catch (Exception e){
            e.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setSuccessMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult uploadAttendanceFile(long pAttnUploadedFileId) {
        ActionResult actionResult = new ActionResult();
        try {
//            AttendanceUploadedFiles uploadedFileObj = attendanceUploadFilesRepository.findOne(pAttnUploadedFileId);
        	AttendanceUploadedFiles uploadedFileObj = attendanceUploadFilesRepository.getOne(pAttnUploadedFileId);
            Path path = Paths.get(uploadedFileObj.getUploadedPathName());

            //Delete existing temp data before new upload
            List<DeviceRowUploadedData> uploadedData = uploadedDataRepository.findAll();
            if(uploadedData.size() > 0){
                uploadedDataRepository.deleteAll();
            }

            // Read files and insert into temporary table
            readFile(path,pAttnUploadedFileId);

            //Update upload status
            uploadedFileObj.setUploadedStatus("pending");
            attendanceUploadFilesRepository.save(uploadedFileObj);

            //return success message
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("File uploaded successfully");
        }
        catch (Exception e){
            e.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setSuccessMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult confirmOneAttendanceFile(long pAttnUploadedFileId) {
        ActionResult actionResult = new ActionResult();
        try {
        //    attendanceProcess(pAttnUploadedFileId);

            //Update upload status
//            AttendanceUploadedFiles uploadedFileObj = attendanceUploadFilesRepository.findOne(pAttnUploadedFileId);
        	AttendanceUploadedFiles uploadedFileObj = attendanceUploadFilesRepository.getOne(pAttnUploadedFileId);
            uploadedFileObj.setUploadedStatus("success");
            attendanceUploadFilesRepository.save(uploadedFileObj);
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Attendance records are successfully saved!");
        }catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setSuccessMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult processAttendanceFile() {
        ActionResult actionResult = new ActionResult();
        String message = "";
        List<AttendanceUploadedFiles> uploadedFiles = attendanceUploadFilesRepository.getProcessableFiles();
        if(uploadedFiles.size() > 0)
        {
            for (AttendanceUploadedFiles uploadedFileObj : uploadedFiles) {
                try {
                    uploadedFileObj.setUploadedStatus("processing");
                    uploadedFileObj.setComments("Processing");
                    attendanceUploadFilesRepository.save(uploadedFileObj);

                    List<Object[]> attList = attendanceUploadFilesRepository.getProcessableAttendanceDataWithObject(uploadedFileObj.getId());
                    List<DailyAttendance> dailyAttendanceObj = new ArrayList<>();
                    dailyAttendanceObj = attList.stream().map(mapToDailyAttendance).collect(Collectors.toList());

                    if(dailyAttendanceObj.size() > 0) {
                        //bulkInsertDailyAttendanceWithEntityManager(attList);
                        int size = dailyAttendanceObj.size();
                        int counter = 0;
                        List<DailyAttendance> dailyAttendances = new ArrayList<>();
                        for (DailyAttendance attendance : dailyAttendanceObj) {
                            dailyAttendances.add(attendance);
                            if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
//                                dailyAttendanceRepository.save(dailyAttendances);
                            	dailyAttendanceRepository.saveAll(dailyAttendances);
                                dailyAttendances.clear();
                            }
                            counter++;
                        }
                    }

                    deviceRowDataTempRepository.getUploadedDevice(uploadedFileObj.getId());

                    processAttendanceReport();


                    uploadedFileObj.setUploadedStatus("success");
                    uploadedFileObj.setComments("Process Success");
                    attendanceUploadFilesRepository.save(uploadedFileObj);


                } catch (Exception e) {
                    e.printStackTrace();
                    uploadedFileObj.setUploadedStatus("failed");
                    uploadedFileObj.setComments(e.getMessage().substring(0,e.getMessage().length() > 255 ? 255 : e.getMessage().length()));
                    attendanceUploadFilesRepository.save(uploadedFileObj);
                }
            }
            message = "File processing Started!";
        }else{
            message = "There is no records exists for saving!";
        }

        actionResult.setIsSuccess(true);
        actionResult.setSuccessMessage(message);

        return actionResult;
    }

    @Override
    public ActionResult deleteAttendanceFile(long pAttnUploadedFileId) {
        ActionResult actionResult = new ActionResult();
        try {
//            attendanceUploadFilesRepository.delete(pAttnUploadedFileId);
        	attendanceUploadFilesRepository.deleteById(pAttnUploadedFileId);
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("File deleted successfully");
        }
        catch (Exception e){
            e.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setSuccessMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<AttendanceUploadedFiles> getAllUploadFiles() {
        return attendanceUploadFilesRepository.getAllUploadFiles();
    }

   /* private DeviceRowUploadedData getFileData(String[] metadata,long pAttnUploadedFileId) {
        String date = metadata[2].trim();
        int year = Integer.parseInt("20" + date.substring(4,6));
        int month = Integer.parseInt( date.substring(2,4)) - 1;
        int dateVal = Integer.parseInt(date.substring(0,2));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,dateVal,0,0,0);


        DeviceRowUploadedData data = new DeviceRowUploadedData();
        data.setReaderName(metadata[0].trim());
        data.setUserId(metadata[1].trim());

        data.setPunchDate(DateUtils.removeTimeZone(calendar.getTime()));
        data.setPunchTime(metadata[3].trim());
        data.setUserActivityStatus(metadata[4].trim());
        data.setPunchType(metadata[5].trim());

        data.setDateAdded();

        return data;
    }
*/
    private DeviceRowDataTemp getDeviceRowDataTemp(DeviceRowUploadedData data, String pEmployeeCode,long pAttnUploadedFileId) {
        DeviceRowDataTemp temp = new DeviceRowDataTemp();
        Calendar workDate = Calendar.getInstance();

        temp.setAttnUploadedFileId(pAttnUploadedFileId);
        temp.setEmployeeCode(pEmployeeCode);
        temp.setPunchCardNo(data.getUserId());
        temp.setPunchType(data.getPunchType());

        workDate.setTime(data.getPunchDate());
        workDate.set(Calendar.HOUR, 0);
        workDate.set(Calendar.MINUTE, 0);
        workDate.set(Calendar.SECOND, 0);
        temp.setWorkDate(workDate.getTime());

        workDate.set(Calendar.HOUR, Integer.parseInt(data.getPunchTime().substring(0,2)));
        workDate.set(Calendar.MINUTE,  Integer.parseInt(data.getPunchTime().substring(3,5)));
        temp.setPunchTime(workDate.getTime());

        temp.setDeviceID(data.getReaderName());
        temp.setBCSynchronize(false);


        return temp;
    }


    @Override
    public ResponseEntity<Resource> getFile(@RequestBody @PathVariable String filename) throws IOException {

        File directory = ErpUtils.getResourcdeDirectory(StaticName.FILE_UPLOADED_FOLDER );
        File file = new File(directory.getAbsolutePath()+ "/" + filename);
        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }
        Resource resource = new UrlResource(file.toURI());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }


    private String readFile(Path path, long pAttnUploadedFileId) throws IOException,ParseException {
        String msg;
        try
        {
            List<DeviceRowUploadedData> fileDatas = new ArrayList<>();

            BufferedReader br = Files.newBufferedReader(path);
            this.attFileId = pAttnUploadedFileId;
            fileDatas = br.lines().map(mapToItem).collect(Collectors.toList());
            br.close();

            if(fileDatas.size() > 0) {
                //bulkInsertDeviceRowUploadedDataWithEntityManager(fileDatas);

                int size = fileDatas.size();
                int counter = 0;
                List<DeviceRowUploadedData> temp = new ArrayList<>();
                for (DeviceRowUploadedData uploadedData : fileDatas) {
                    temp.add(uploadedData);
                    if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
//                        uploadedDataRepository.save(temp);
                    	uploadedDataRepository.saveAll(temp);
                        temp.clear();
                    }
                    counter++;
                }
            }

            List<Object[]> rowDataTemps = uploadedDataRepository.getUploadedDevice();

            List<DeviceRowDataTemp> tempDeviceRow = new ArrayList<>();
            tempDeviceRow = rowDataTemps.stream().map(mapToDeviceTemp).collect(Collectors.toList());

            if(tempDeviceRow.size() > 0) {
                //bulkInsertDeviceRowDataTempWithEntityManager(rowDataTemps);
                int size = fileDatas.size();
                int counter = 0;
                List<DeviceRowDataTemp> dataTemps = new ArrayList<>();
                for (DeviceRowDataTemp deviceRowDataTemp : tempDeviceRow) {
                    dataTemps.add(deviceRowDataTemp);
                    if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
//                        deviceRowDataTempRepository.save(dataTemps);
                    	deviceRowDataTempRepository.saveAll(dataTemps);
                        dataTemps.clear();
                    }
                    counter++;
                }

                if(dataTemps.size() > 0){
//                    deviceRowDataTempRepository.save(dataTemps);
                	deviceRowDataTempRepository.saveAll(dataTemps);
                    dataTemps.clear();
                }
                msg = "process pending";
            }else{
                msg = "already processed";
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return msg;
    }

    private Function<String, DeviceRowUploadedData> mapToItem = (line) -> {
        String[] metadata = line.split(",");

        String date = metadata[2].trim();
        int year = Integer.parseInt("20" + date.substring(4,6));
        int month = Integer.parseInt( date.substring(2,4)) - 1;
        int dateVal = Integer.parseInt(date.substring(0,2));

        String [] time = metadata[3].trim().split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,dateVal,0,0,0);

        Calendar pTime = Calendar.getInstance();
        pTime.set(year,month,dateVal,hour,min,0);

        DeviceRowUploadedData data = new DeviceRowUploadedData();
        data.setReaderName(metadata[0].trim());
        data.setUserId(metadata[1].trim());

        data.setPunchDate(DateUtils.removeTimeZone(calendar.getTime()));
        data.setPunchTime(metadata[3].trim());
        data.setUserActivityStatus(metadata[4].trim());
        data.setPunchType(metadata[5].trim());
        data.setpTime(DateUtils.getFormatedDate(pTime.getTime()));

        data.setAttFileId(attFileId);

        data.setDateAdded();
        return data;
    };

    private Function<Object[], DeviceRowDataTemp> mapToDeviceTemp = (data) -> {
        DeviceRowDataTemp dataTemp = new DeviceRowDataTemp();
        dataTemp.setEmployeeCode(data[0].toString());
        dataTemp.setPunchTime((Date)data[1]);
        dataTemp.setWorkDate((Date)data[2]);
        dataTemp.setPunchCardNo(data[3].toString());
        dataTemp.setDeviceID(data[4].toString());
        dataTemp.setAttnUploadedFileId((long)data[5]);
        dataTemp.setShiftType(data[6].toString());
        dataTemp.setShiftID(data[7].toString());
        dataTemp.setLate(false);
        dataTemp.setProcessed(false);

        Date pInTime = (data[8] == null?(Date)data[2] : DateUtils.getDateTime((Date)data[2], data[8].toString()));
        Date pOutTime = (data[9] == null?(Date)data[2] : DateUtils.getDateTime((Date)data[2], data[9].toString()));
        Date pLunchInTime = (data[10] == null?(Date)data[2] : DateUtils.getDateTime((Date)data[2],data[10].toString()));
        Date pLunchOutTime = (data[11] == null?(Date)data[2] : DateUtils.getDateTime((Date)data[2], data[11].toString()));
        Date punchTime = (Date)data[1];


        if (pOutTime.before(punchTime) || pOutTime.equals(punchTime)) {
            dataTemp.setPunchType("Out");
        } else if (pLunchInTime.before(punchTime) || pLunchInTime.equals(punchTime)) {
            dataTemp.setPunchType("LIn");
        } else if (pLunchOutTime.before(punchTime) || pLunchOutTime.equals(punchTime)) {
            dataTemp.setPunchType("LOut");
        } else if (pInTime.before(punchTime)) {
            dataTemp.setPunchType("In");
        } else {
            dataTemp.setPunchType("In");
        }

        return dataTemp;
    };

    private Function<Object[], DailyAttendance> mapToDailyAttendance = (data) -> {
        DailyAttendance dailyAttendance = new DailyAttendance();
        dailyAttendance.setEmployeeCode(data[0].toString());
        dailyAttendance.setWorkDate((Date)data[1]);
        dailyAttendance.setShiftID(data[2].toString());
        dailyAttendance.setShiftType(data[3].toString());
        dailyAttendance.setPunchType(data[4].toString());
        dailyAttendance.setpTime((Date) data[5]);
        dailyAttendance.setBcTime((Date)data[1]);
        dailyAttendance.setLate(false);
        dailyAttendance.setManual(false);
        dailyAttendance.setReportProcessed(false);
        return dailyAttendance;
    };

    private Function<Object[], DailyAttendanceReport> mapToDailyAttendanceReport = (data) -> {
        DailyAttendanceReport attReport = new DailyAttendanceReport();
        attReport.setEmployeeCode(data[0].toString());
        attReport.setPunchCardNo(data[1].toString());
        attReport.setEmployeeName(data[2].toString());
        attReport.setDoj((Date) data[3]);
        attReport.setDepartment(data[4].toString());
        attReport.setSection(data[5].toString());
        attReport.setDesignation(data[6].toString());
        attReport.setUnit(data[7].toString());
        attReport.setFloor(data[8].toString());
        attReport.setLine(data[9].toString());
        attReport.setStaffCategory(data[10].toString());
        attReport.setShiftID(data[11].toString());
        attReport.setWorkDate((Date) data[12]);
        attReport.setPunchInTime((Date) data[13]);
        attReport.setPunchOutTime((Date) data[14]);
        attReport.setShiftInTime(data[15].toString());
        attReport.setShiftOutTime(data[16].toString());
        attReport.setShiftOutTimeEndMargin(data[17].toString());
        BigDecimal workingHour = (BigDecimal) data[18];
        attReport.setWorkingHour(workingHour.floatValue());
        attReport.setId((long) data[21]);

        int otHour = getOTHour((Date) data[13], (Date) data[14],(Date) data[12],data[16].toString());
        attReport.setOtHour(otHour);

        int lateCountInMinute = getLateCountInMinute((Date) data[13],(Date) data[12],data[16].toString());
        attReport.setLateCountInMinute(lateCountInMinute);
        String late = lateCountInMinute > 0 ? "L" : null;
        attReport.setLate(late);
        String dayStatus =null;
        if(attReport.getPunchInTime().compareTo(attReport.getPunchOutTime()) != 0 &&
                (attReport.getPunchInTime().compareTo(attReport.getWorkDate()) !=0 || attReport.getPunchOutTime().compareTo(attReport.getWorkDate()) !=0) )
            dayStatus = "P";
        else if(!data[19].toString().trim().equals("") )
            dayStatus = data[19].toString();
        else if (Integer.parseInt(data[20].toString().trim()) != 0)
            dayStatus ="LV";
        else
            dayStatus = "A";

        attReport.setDayStatus(dayStatus);
        attReport.setProcessCompleted(true);
        return attReport;
    };

    private int getOTHour(Date punchInTime,Date punchOutTime,Date workDate , String time){
        int otHour = 0;
        if(punchInTime != null && punchOutTime != null )
            try {
                if(punchInTime.compareTo(workDate) != 0 ) {
                    long seconds = (punchOutTime.getTime() - DateUtils.getDateTime(workDate, time).getTime()) / 1000;
                    otHour = (int) (seconds / 3600);
                }
            } catch (Exception e){
                // e.printStackTrace();
            }
        return otHour;
    }
    private int getLateCountInMinute(Date punchInTime,Date workDate  , String time){
        int lateMinutes = 0;
        try {
            if(punchInTime.compareTo(workDate) != 0 ) {
                long seconds = (punchInTime.getTime() - DateUtils.getDateTime(workDate, time).getTime()) / 1000;
                lateMinutes = (int) (seconds / 60);
            }
        } catch (Exception e){
            //  e.printStackTrace();
        }
        return lateMinutes;
    }

    private void processAttendanceReport(){
        List<Date>dates = dailyAttendanceRepository.getProcessableDates();
        for (Date date:dates) {
            List<Object[]> reports = dailyAttendanceRepository.getProcessableAttendance(date);
            List<DailyAttendanceReport> dailyAttendanceReportsObj = new ArrayList<>();
            dailyAttendanceReportsObj = reports.stream().map(mapToDailyAttendanceReport).collect(Collectors.toList());

            if(dailyAttendanceReportsObj.size() > 0) {
                //bulkInsertDailyAttendanceWithEntityManager(attList);
                int size = dailyAttendanceReportsObj.size();
                int counter = 0;
                List<DailyAttendanceReport> attendanceReports = new ArrayList<>();
                for (DailyAttendanceReport attendanceReport : dailyAttendanceReportsObj) {
                    attendanceReports.add(attendanceReport);
                    if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
//                        attendanceReportRepository.save(attendanceReports);
                    	attendanceReportRepository.saveAll(attendanceReports);
                        attendanceReports.clear();
                    }
                    counter++;
                }
            }
        }
        if(dates.size() > 0)
            dailyAttendanceRepository.updateAttendanceProcessStatus(dates);
    }

    private void bulkInsertDailyAttendanceReportWithEntityManager(List<DailyAttendanceReport> items) {
        BulkInsetUtil.bulkInsertWithEntityManager(emf,items);
    }

    private void bulkInsertDeviceRowUploadedDataWithEntityManager(List<DeviceRowUploadedData> items) {
        //BulkInsetUtil.bulkInsertWithEntityManager(emf,items);
        int size = items.size();
        int counter = 0;
        List<DeviceRowUploadedData> temp = new ArrayList<>();
        for (DeviceRowUploadedData uploadedData : items) {
            temp.add(uploadedData);
            if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
//                uploadedDataRepository.save(temp);
            	uploadedDataRepository.saveAll(temp);
                temp.clear();
            }
            counter++;
        }
    }

    private void  bulkInsertDeviceRowDataTempWithEntityManager(List<DeviceRowDataTemp> tempList) {
        BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
    private void bulkInsertDailyAttendanceWithEntityManager(List<DailyAttendance> tempList) {
        BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
}
