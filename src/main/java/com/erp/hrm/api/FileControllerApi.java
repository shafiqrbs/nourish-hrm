package com.erp.hrm.api;

import com.erp.hrm.domain.AttendanceUploadedFiles;
import com.erp.hrm.service.FileService;
import com.erp.hrm.util.ActionResult;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/file")
@MultipartConfig
public class FileControllerApi {

    private FileService fileService;

    public FileControllerApi(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value ="/uploadFile", method = RequestMethod.POST)
    public ActionResult uploadFile( @RequestBody @RequestParam(value = "file")  MultipartFile file) {
        if (file == null || file.isEmpty()) {
           throw new RuntimeException("File is not selected or Empty");
        }
        List<MultipartFile> list = new ArrayList<>();
        list.add(file);
        return fileService.save(list);
    }

    @RequestMapping(value ="/uploadMultipleFiles", method = RequestMethod.POST)
    public ActionResult uploadMultipleFiles(@RequestBody @RequestParam("files") List<MultipartFile> files) throws FileNotFoundException{
        if (files == null || files.size() == 0) {
            throw new FileNotFoundException("No File");
        }
        return fileService.save(files);
    }


    @RequestMapping(value ="/processUploadedFile", method = RequestMethod.POST)
    public ActionResult processUploadedFile( ){
        return fileService.processAttendanceFile();
    }


    @RequestMapping(value = "/getAllUploadFiles",method = RequestMethod.GET)
    public List<AttendanceUploadedFiles> getAllUploadFiles(){
        return fileService.getAllUploadFiles();
    }

    @RequestMapping(value = "/uploadAllInitialAttendanceFile",method = RequestMethod.GET)
    public ActionResult uploadAllInitialAttendanceFile(){
        return fileService.uploadAllInitialAttendanceFile();
    }

    @RequestMapping(value = "/uploadAttendanceFile",method = RequestMethod.GET)
    public ActionResult uploadAttendanceFile(long fileRowId){
        return fileService.uploadAttendanceFile(fileRowId);
    }

    @RequestMapping(value = "/confirmSingleAttendanceFile",method = RequestMethod.GET)
    public ActionResult confirmOneAttendanceFile(long fileRowId){
        return fileService.confirmOneAttendanceFile(fileRowId);
    }


    @RequestMapping(value = "/deleteAttendanceFile",method = RequestMethod.GET)
    public ActionResult deleteAttendanceFile(long fileRowId){
        return fileService.deleteAttendanceFile(fileRowId);
    }

    @RequestMapping(value = "/getFile/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getFile(@RequestBody @PathVariable String filename) throws IOException {

        return fileService.getFile(filename);
    }

}
