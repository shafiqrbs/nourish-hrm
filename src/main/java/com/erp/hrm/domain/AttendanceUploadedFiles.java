package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 28/11/2018.
 */
@Entity
@Table( name = "AttendanceUploadedFiles" )
public class AttendanceUploadedFiles extends BaseEntity {

    @Size(max = 256)
    @NotNull
    @Column(name = "FileName")
    private String fileName;

    @Size(max = 100)
    @Column(name = "FileType")
    private String fileType;

    @Column(name = "FileSize")
    private long fileSize;

    @Size(max = 100)
    @Column(name = "UploadedFolderName")
    private String uploadedFolderName;

    @Size(max = 256)
    @Column(name = "UploadedPathName")
    private String uploadedPathName;

    @Size(max = 32)
    @Column(name = "UploadedStatus")
    private String uploadedStatus;

    @Size(max = 256)
    @Column(name = "Comments")
    private String comments;

    @Size(max = 250)
    @Column(name = "UserId")
    private String userId;

    @Column(name = "NoOfRows")
    private long noOfRows;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadedFolderName() {
        return uploadedFolderName;
    }

    public void setUploadedFolderName(String uploadedFolderName) {
        this.uploadedFolderName = uploadedFolderName;
    }

    public String getUploadedPathName() {
        return uploadedPathName;
    }

    public void setUploadedPathName(String uploadedPathName) {
        this.uploadedPathName = uploadedPathName;
    }

    public String getUploadedStatus() {
        return uploadedStatus;
    }

    public void setUploadedStatus(String uploadedStatus) {
        this.uploadedStatus = uploadedStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(long noOfRows) {
        this.noOfRows = noOfRows;
    }
}
