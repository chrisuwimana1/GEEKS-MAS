package com.mum.edu.geek.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Course implements Serializable {
    @Id
    @Column(nullable = false, length = 10)
    private String id;
    @Column(nullable = false, length = 80)
    @NaturalId
    private String name;
    @Column(nullable = false)
    private Integer numberOfWeeks;
    @Column(nullable = false)
    private Integer totalDaysOff;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(int numberOfWeek) {
        this.numberOfWeeks = numberOfWeek;
    }

    public int getTotalDaysOff() {
        return totalDaysOff;
    }

    public void setTotalDaysOff(int numberOfSession) {
        this.totalDaysOff = numberOfSession;
    }

    public void setNumberOfWeek(Integer numberOfWeek) {
        this.numberOfWeeks = numberOfWeek;
    }

    public void setNumberOfSession(Integer numberOfSession) {
        this.totalDaysOff = numberOfSession;
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
                ", numberOfWeeks=" + numberOfWeeks +
                ", totalDaysOff=" + totalDaysOff +
                '}';
    }
}
