package com.mum.edu.geek.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reporting {
    @Id
    private Integer studentId;
    private LocalDate attendanceDate;
    private LocalDate sectionStartDate;
    private Integer blockId;
    private Integer numberOfWeeks;
    private String attendanceType;
    private Integer totalDaysOff;

    public Integer getStudentId() {
        return studentId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    public LocalDate getSectionStartDate() {
        return sectionStartDate;
    }

    public Integer getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public Integer getTotalDaysOff() {
        return totalDaysOff;
    }
}