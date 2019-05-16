package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Entity
public class Attendance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate attendanceDate;
    @Column(length = 3,nullable = false)
    private String attendanceTime;
    @OneToOne(cascade = CascadeType.ALL,optional = false)
    private Student student;
    @OneToOne(cascade = CascadeType.ALL,optional = false)
    private Location location;


    public Attendance(){}

    public Attendance(Location location,Student student,String dateCol,String timeCol){
        this.attendanceDate = LocalDate.parse(dateCol, DateTimeFormatter.ofPattern("mm/dd/yyyy"));
        this.setAttendanceTime(timeCol);
        this.setLocation(location);
        this.setStudent(student);
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendance)) return false;
        Attendance that = (Attendance) o;
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
                ", student=" + student +
                ", location=" + location +
                '}';
    }
}
