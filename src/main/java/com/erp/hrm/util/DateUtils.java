package com.erp.hrm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //private static final SimpleDateFormat format24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String date) throws ParseException {
        return FORMAT.parse(date);
    }

    public static Date parse(String date, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    public static String format(Date date) {
        if(date == null)
            throw new RuntimeException("Date is null");
        String dateString = FORMAT.format(date);
        return dateString;
    }



    public static String format(Date date, String format) {
        if(date == null)
            throw new RuntimeException("Date is null");
        String dateString =  new SimpleDateFormat(format).format(date);
        return dateString;
    }
    public static Date setDefaultTime(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),0,0,0);
        return calendar.getTime();
    }
    public static Date removeTimeZone(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        try {
            return parse(format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static Date getFormatedDate(Date date){
        try {
            return parse(format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }

    public static Date getDateTime(Date workDate, String time){
        try {
            workDate = DateUtils.parse(format(workDate, "yyyy-MM-dd") + " " + time);
        } catch (ParseException e) {
            //e.printStackTrace();
        }
        return workDate;
    }

    public static int[] getDateDiffrece(Date fromDate, Date toDate) {
        int[] serviceLength = new int[3];
        try{
            Calendar cal = Calendar.getInstance();

            cal.setTime(fromDate);
            LocalDate from = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));                          //Today's date
            cal.setTime(toDate);
            LocalDate to = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));                          //Today's date

            Period period = Period.between(from, to);

            serviceLength[0] = period.getYears();
            serviceLength[1] = period.getMonths();
            serviceLength[2] = period.getDays();
        }catch (Exception ex){
            ex.printStackTrace();
            serviceLength[0] = 0;
            serviceLength[1] = 0;
            serviceLength[2] = 0;
        }
        return serviceLength;

    }

}
