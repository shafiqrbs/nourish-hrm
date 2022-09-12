package com.erp.hrm.api.dto.attendance;

import java.util.List;

/**
 * Created by SA
 */
public class AttendanceHistoryGridDTO {
    private int total;
    private List<DailyAttendanceDTO> data;

    public AttendanceHistoryGridDTO() {
    }

    public AttendanceHistoryGridDTO(int total, List<DailyAttendanceDTO> data) {
        this.total = total;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DailyAttendanceDTO> getData() {
        return data;
    }

    public void setData(List<DailyAttendanceDTO> data) {
        this.data = data;
    }
}
