package com.mum.edu.geek.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentSectionId implements Serializable {
    private Integer studentId;
    private Integer sectionId;

    public StudentSectionId(Integer studentId, Integer blockId) {
        this.studentId = studentId;
        this.sectionId = blockId;
    }

    public StudentSectionId() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer blockId) {
        this.sectionId = blockId;
    }
}
