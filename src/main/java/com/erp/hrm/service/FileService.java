package com.erp.hrm.service;

import com.erp.hrm.domain.AttendanceUploadedFiles;
import com.erp.hrm.domain.City;
import com.erp.hrm.util.ActionResult;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by WS on 04/08/2018.
 */
public interface FileService {
    ActionResult save(List<MultipartFile> files);

    List<AttendanceUploadedFiles> getAllUploadFiles();

    ActionResult uploadAttendanceFile(long pAttnUploadedFileId);

    ActionResult uploadAllInitialAttendanceFile();

    ActionResult confirmOneAttendanceFile(long pAttnUploadedFileId);

    ActionResult processAttendanceFile();

    ActionResult deleteAttendanceFile(long pAttnUploadedFileId);


    ResponseEntity<Resource> getFile(String filename) throws IOException;

}
