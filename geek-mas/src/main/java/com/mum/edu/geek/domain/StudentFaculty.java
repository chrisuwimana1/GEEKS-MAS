package com.mum.edu.geek.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

@Entity
public class StudentFaculty implements Serializable {

    @EmbeddedId
    private StudentSectionId studentSectionId;
    //private Integer studentId;
    private String studentName;
    private Integer numberOfWeeks;
    private Integer totalDaysOff;
    private Integer attended;
    //private Integer sectionId;
    private Integer blockId;
    private String blockName;
    private String courseId;
    private String courseName;
    private LocalDate sectionStartDate;
    private Integer facultyId;
    private String facultyName;
    private Integer cancelledSession;
    @Column(name = "extra_point")
    private BigDecimal bonusPoints;
    @Column(name = "extra_point_days")
    private Integer requiredDays;
    private BigDecimal tmPercent;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAttended() {
        return attended;
    }

    public void setAttended(Integer attended) {
        this.attended = attended;
    }

    public StudentSectionId getStudentSectionId() {
        return studentSectionId;
    }

    public Integer getBlockId() {
        return blockId;
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
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getCancelledSession() {
        return cancelledSession;
    }

    public void setCancelledSession(Integer cancelledSession) {
        this.cancelledSession = cancelledSession;
    }

    public Integer getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(Integer numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    public Integer getTotalDaysOff() {
        return totalDaysOff;
    }

    public void setTotalDaysOff(Integer totalDaysOff) {
        this.totalDaysOff = totalDaysOff;
    }

    public BigDecimal getBonusPoints() {
        return bonusPoints == null ? null : bonusPoints.round(new MathContext(3));
    }

    public void setBonusPoints(BigDecimal bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public String getBlockName() {
        return blockName;
    }

    public Integer getTotalPossibleDays() {
        return getNumberOfWeeks() == null ? null : getNumberOfWeeks() * 6 - getCancelledSession();
    }

    public BigDecimal getTmPercent() {
        return tmPercent == null ? null : tmPercent.round(new MathContext(3));
    }


}
