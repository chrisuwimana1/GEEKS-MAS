package com.mum.edu.geek.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Course implements Serializable {
    @Id
    @Column(nullable = false, length = 5)
    private Integer id;
    @Column(nullable = false, length = 80)
    private String name;
    @Column(length = 500)
    private String description;
    @Column(nullable = false)
    private Integer numberOfWeek;
    @Column(nullable = false)
    private Integer numberOfSession;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public int getNumberOfSession() {
        return numberOfSession;
    }

    public void setNumberOfSession(int numberOfSession) {
        this.numberOfSession = numberOfSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberOfWeek=" + numberOfWeek +
                ", numberOfSession=" + numberOfSession +
                '}';
    }
}
