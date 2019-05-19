package com.mum.edu.geek.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Entry entry;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Enroll> enrollList;

    @OneToMany( mappedBy = "student")
    @JsonIgnore
    private List<TmSession> tmSessionList;

    public Student(){}

    public Student(Integer id){
        this.id = id;
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
