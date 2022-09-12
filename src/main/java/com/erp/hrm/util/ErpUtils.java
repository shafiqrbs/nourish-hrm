package com.erp.hrm.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SOHAG on 5/16/2018.
 */
public class ErpUtils {

    public static String generateMaternityLeaveTransId(String pPrefix, Date pFromDate, int pSerialNo){
        Calendar from = Calendar.getInstance();
        from.setTime(pFromDate);
        return (pPrefix + "-" + from.get(Calendar.YEAR) + "-" + (pSerialNo + 1));
    }

    public static Date todayDate() throws ParseException {
        Date todayDate = new Date();
        String vTodayDate = new SimpleDateFormat("yyyy-MM-dd").format(todayDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(vTodayDate); // parse today date
        return date;
    }

    public static String encoded(String pValue){
        String encoded =  Base64.encodeBase64String(pValue.getBytes());
        return  encoded;
    }

    public static boolean getBoolean(Object bool){
        boolean flag = false;
        try {
            flag =(boolean) bool;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  flag;
    }



    public static File getResourcdeDirectory(String subDirPath) throws IOException {
        File resourcePath = new ClassPathResource("application.properties").getFile();
        String pathDir = resourcePath.getAbsolutePath().replace("application.properties","") + subDirPath;

        File directory = new File(pathDir);

        if (! directory.exists())
            directory.mkdirs();
        return  directory;
    }

}
