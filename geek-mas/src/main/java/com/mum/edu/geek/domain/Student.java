package com.mum.edu.geek.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Student implements Serializable {
    @Id
    @Column(length = 6)
    private Integer id;
    @Column(length = 100,nullable = false)
    private String name;
    @NaturalId
    private Long barCodeId;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Entry entry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Enroll> enrollList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<TmSession> tmSessionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Attendance> attendanceList;

    public Student() {
    }

    public Student(Integer studentId) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public Long getBarCodeId() {
        return barCodeId;
    }

    public void setBareCodeId(Long barCodeId) {
        this.barCodeId = barCodeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBarCodeId(Long barCodeId) {
        this.barCodeId = barCodeId;
    }

    public List<Enroll> getEnrollList() {
        return enrollList;
    }

    public void setEnrollList(List<Enroll> enrollList) {
        this.enrollList = enrollList;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId();
    }

    public List<TmSession> getTmSessionList() {
        return tmSessionList;
    }

    public void setTmSessionList(List<TmSession> tmSessions) {
        this.tmSessionList = tmSessions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bareCodeId=" + barCodeId +
                ", user=" + user +
                ", entry=" + entry +
                '}';
    }

}
