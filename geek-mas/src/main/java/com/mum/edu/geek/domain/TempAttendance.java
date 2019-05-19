package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public class TempAttendance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate attendanceDate;
    @Column(length = 3,nullable = false)
    private String attendanceTime;
    private Integer studentId;
    private String location;


    public TempAttendance(){}

    public TempAttendance(String dateCol, String attendanceTime, Integer studentId, String location) {
        this.attendanceDate = LocalDate.parse(dateCol, DateTimeFormatter.ofPattern("MM/dd/yy"));
        this.attendanceTime = attendanceTime;
        this.studentId = studentId;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(String attendanceTime) {
        this.attendanceTime = attendanceTime;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TempAttendance)) return false;
        TempAttendance that = (TempAttendance) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", attendanceDate=" + attendanceDate +
                ", attendanceTime='" + attendanceTime + '\'' +
                ", studentId=" + studentId +
                ", location=" + location +
                '}';
    }
}
