package com.mum.edu.geek.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class ReportingId implements Serializable {
    private Integer studentId;
    private LocalDate attendanceDate;

    public ReportingId(Integer studentId, LocalDate attendanceDate) {
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
    }

    public ReportingId() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}
