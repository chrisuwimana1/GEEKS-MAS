package com.mum.edu.geek.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class StudentSection implements Serializable {
    @Id
    private Integer studentId;
    private String studentName;
    private Integer possible;
    private Integer attended;
    private Integer cancelledSession;
    private Integer blockId;
    private String blockName;
    private Integer sectionId;
    private String courseId;
    private String courseName;
    private Integer possibleCumul;
    private Integer attendedCumul;
    private Integer cancelledSessionCumul;

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

    public Integer getPossibleCumul() {
        return possibleCumul;
    }

    public void setPossibleCumul(Integer possibleCumul) {
        this.possibleCumul = possibleCumul;
    }

    public Integer getAttendedCumul() {
        return attendedCumul;
    }

    public void setAttendedCumul(Integer attendedCumul) {
        this.attendedCumul = attendedCumul;
    }

    public Integer getCancelledSessionCumul() {
        return cancelledSessionCumul;
    }

    public void setCancelledSessionCumul(Integer cancelledSessionCumul) {
        this.cancelledSessionCumul = cancelledSessionCumul;
    }

    public Integer getCancelledSession() {
        return cancelledSession;
    }

    public void setCancelledSession(Integer cancelledSession) {
        this.cancelledSession = cancelledSession;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentSection)) return false;
        StudentSection that = (StudentSection) o;
        return Objects.equals(getStudentId(), that.getStudentId()) &&
                Objects.equals(getSectionId(), that.getSectionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getSectionId());
    }

    @Override
    public String toString() {
        return "StudentSectionRepository{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", possible=" + possible +
                ", attended=" + attended +
                ", blockId=" + blockId +
                ", sectionId=" + sectionId +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", possibleCumul=" + possibleCumul +
                ", attendedCumul=" + attendedCumul +
                '}';
    }
}
