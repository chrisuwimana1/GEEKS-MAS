package com.mum.edu.geek.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class TmSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "Session Date cant be null")
    private LocalDate sessionDate;

    @Column(nullable = false, length = 20)
    @NotEmpty(message = "Session Type cant be empty")
    @Size(min = 10,max = 20,message = "Wrong size of Session Type")
    private String sessionType;

    @ManyToOne
    @NotNull(message = "Student cant be null")
    private Student student;
//    @OneToOne(cascade = CascadeType.ALL)
//    private Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TmSession)) return false;
        TmSession tmSession = (TmSession) o;
        return Objects.equals(getId(), tmSession.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TmSession{" +
                "id=" + id +
                ", sessionDate=" + sessionDate +
                ", sessionType='" + sessionType + '\'' +
                ", student=" + student +
                '}';
    }
}