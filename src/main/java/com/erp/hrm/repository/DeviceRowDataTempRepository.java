package com.erp.hrm.repository;

import com.erp.hrm.domain.DeviceRowDataTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WS on 04/08/2018.
 */
@Repository
public interface DeviceRowDataTempRepository extends JpaRepository<DeviceRowDataTemp, Long>{
    @Transactional
    @Modifying
    @Query("UPDATE DeviceRowDataTemp  DRUT SET isProcessed = true" +
            " WHERE DRUT.attnUploadedFileId = :attnUploadFileId"
    )
    void getUploadedDevice(@Param("attnUploadFileId")Long attnUploadFileId);

}
