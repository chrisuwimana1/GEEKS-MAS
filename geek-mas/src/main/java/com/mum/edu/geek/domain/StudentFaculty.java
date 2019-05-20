package com.mum.edu.geek.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Objects;
@Entity
public class StudentFaculty implements Serializable {
    @Id
    private Integer studentId;
    private String studentName;
    private Integer numberOfWeeks;
    private Integer totalDaysOff;
    private Integer attended;
    private Integer sectionId;
    private Integer blockId;
    private String blockName;
    private String courseId;
    private String courseName;
    private LocalDate sectionStartDate;
    private Integer facultyId;
    private String FacultyName;
    private Integer cancelledSession;
    private Integer extraPoint;
    private Integer extraPointDays;
    private BigDecimal tmPercent;

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
    public Integer getAttended() {
        return attended;
    }

    public void setAttended(Integer attended) {
        this.attended = attended;
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

    public Integer getExtraPoint() {
        return extraPoint;
    }

    public void setExtraPoint(Integer extratPoint) {
        this.extraPoint = extratPoint;
    }

    public Integer getExtraPointDays() {
        return extraPointDays;
    }

    public void setExtraPointDays(Integer extraPointDays) {
        this.extraPointDays = extraPointDays;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public Integer getTotalPossibleDays(){
        return getNumberOfWeeks() * 6 - getCancelledSession();
    }

    public BigDecimal getTmPercent() {
        return tmPercent.round(new MathContext(3));
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

    @Override
    public String toString() {
        return "StudentFaculty{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", numberOfWeeks=" + numberOfWeeks +
                ", totalDaysOff=" + totalDaysOff +
                ", attended=" + attended +
                ", sectionId=" + sectionId +
                ", blockId=" + blockId +
                ", blockName='" + blockName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", sectionStartDate=" + sectionStartDate +
                ", facultyId=" + facultyId +
                ", FacultyName='" + FacultyName + '\'' +
                ", cancelledSession=" + cancelledSession +
                ", extraPoint=" + extraPoint +
                ", extraPointDays=" + extraPointDays +
                ", tmPercent=" + tmPercent +
                '}';
    }
}
