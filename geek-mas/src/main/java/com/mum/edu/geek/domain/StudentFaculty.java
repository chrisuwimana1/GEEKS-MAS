package com.mum.edu.geek.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
@Entity
public class StudentFaculty implements Serializable {
    @Id
    private Integer studentId;
    private String studentName;
    private Integer possible;
    private Integer attended;
    private Integer blockId;
    private Integer sectionId;
    private String courseId;
    private String courseName;
    private LocalDate sectionStartDate;
    private Integer facultyId;
    private String FacultyName;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getPossible() {
        return possible;
    }

    public void setPossible(Integer possible) {
        this.possible = possible;
    }

    public Integer getAttended() {
        return attended;
    }

    public void setAttended(Integer attended) {
        this.attended = attended;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getSectionStartDate() {
        return sectionStartDate;
    }

    public void setSectionStartDate(LocalDate sectionStartDate) {
        this.sectionStartDate = sectionStartDate;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    @Override
    public String toString() {
        return "StudentFaculty{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", possible=" + possible +
                ", attended=" + attended +
                ", blockId=" + blockId +
                ", sectionId=" + sectionId +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", sectionStartDate=" + sectionStartDate +
                ", facultyId=" + facultyId +
                ", FacultyName='" + FacultyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentFaculty)) return false;
        StudentFaculty that = (StudentFaculty) o;
        return Objects.equals(getStudentId(), that.getStudentId()) &&
                Objects.equals(getSectionId(), that.getSectionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getSectionId());
    }
}
