package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Enroll implements Serializable {

    @EmbeddedId
    private EnrollId id;

    @Column(nullable = false)
    private LocalDate enrollDate;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("sectionId")
    private Section section;

    public Enroll() {
    }

    public Enroll(Student student, Section section) {
        this.student = student;
        this.section = section;
        this.id = new EnrollId(section.getId(), student.getId());
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public EnrollId getId() {
        return id;
    }

    public void setId(EnrollId enrollId) {
        this.id = enrollId;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enroll)) return false;
        Enroll enroll = (Enroll) o;
        return Objects.equals(getId(), enroll.getId());
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "id=" + id +
                ", enrollDate=" + enrollDate +
                ", student=" + student +
                ", section=" + section +
                '}';
    }
}
