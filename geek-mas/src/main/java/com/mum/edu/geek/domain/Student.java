package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Student implements Serializable {
    @Id
    @Column(length = 6)
    private Integer id;
    @Column(length = 50,nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    private Long barCodeId;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Entry entry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Enroll> enrollList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<TmSession> tmSessionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bareCodeId=" + barCodeId +
                ", user=" + user +
                ", entry=" + entry +
                '}';
    }

}
