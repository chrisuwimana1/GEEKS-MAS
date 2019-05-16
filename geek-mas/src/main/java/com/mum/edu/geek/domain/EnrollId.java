package com.mum.edu.geek.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrollId implements Serializable {
    private Integer sectionId;
    private Integer studentId;

    public EnrollId() {
    }

    public EnrollId(Integer sectionId, Integer studentId) {
        this.sectionId = sectionId;
        this.studentId = studentId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrollId)) return false;
        EnrollId enrollId = (EnrollId) o;
        return Objects.equals(getSectionId(), enrollId.getSectionId()) &&
                Objects.equals(getStudentId(), enrollId.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSectionId(), getStudentId());
    }

    @Override
    public String toString() {
        return "EnrollId{" +
                "sectionId=" + sectionId +
                ", studentId=" + studentId +
                '}';
    }
}
