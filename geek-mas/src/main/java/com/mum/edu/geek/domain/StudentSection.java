package com.mum.edu.geek.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

@Entity
public class StudentSection implements Serializable {
    @EmbeddedId
    private StudentSectionId studentSectionId;
    private String studentName;
    private Integer numberOfWeeks;
    private Integer totalDaysOff;
    private Integer attended;
    private BigDecimal tmPercent;
    private Integer cancelledSession;
    private Integer blockId;
    private String blockName;
    private String courseId;
    private String courseName;
    private Integer numberOfWeeksCumul;
    private Integer totalDaysOffCumul;
    private Integer attendedCumul;
    @Column(name = "extra_point")
    private BigDecimal bonus;
    private BigDecimal extraPointCumul;
    private Integer cancelledSessionCumul;
    private BigDecimal tmPercentCumul;
//    @Transient
//    private Integer totalDays;

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

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
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

    public Integer getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(Integer numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    public Integer getTotalDays() {
        return getNumberOfWeeks() == null ? null : getNumberOfWeeks() * 6 - getCancelledSession();
    }

    public Integer getTotalDaysOff() {
        return totalDaysOff;
    }

    public void setTotalDaysOff(Integer totalDaysOff) {
        this.totalDaysOff = totalDaysOff;
    }

    public Integer getNumberOfWeeksCumul() {
        return numberOfWeeksCumul;
    }

    public void setNumberOfWeeksCumul(Integer numberOfWeeksCumul) {
        this.numberOfWeeksCumul = numberOfWeeksCumul;
    }

    public Integer getTotalDaysOffCumul() {
        return totalDaysOffCumul;
    }

    public void setTotalDaysOffCumul(Integer totalDaysOffCumul) {
        this.totalDaysOffCumul = totalDaysOffCumul;
    }

    public BigDecimal getTmPercent() {
        return tmPercent == null ? null : tmPercent.round(new MathContext(3));
    }

    public BigDecimal getTmPercentCumul() {
        return tmPercentCumul == null ? null : tmPercentCumul.round(new MathContext(3));
    }

    public StudentSectionId getStudentSectionId() {
        return studentSectionId;
    }

    public Integer getTotalDaysCumul() {
        return getNumberOfWeeksCumul() == null ? null : getNumberOfWeeksCumul() * 6 - getCancelledSessionCumul();
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public BigDecimal geExtraPointCumul() {
        return extraPointCumul;
    }

    public void setStudentSectionId(StudentSectionId studentSectionId) {
        this.studentSectionId = studentSectionId;
    }

    public void setTmPercent(BigDecimal tmPercent) {
        this.tmPercent = tmPercent;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public void setExtraPointCumul(BigDecimal extraPointCumul) {
        this.extraPointCumul = extraPointCumul;
    }

    public void setTmPercentCumul(BigDecimal tmPercentCumul) {
        this.tmPercentCumul = tmPercentCumul;
    }

//    public void setTotalDays(Integer totalDays) {
//        this.totalDays = totalDays;
//    }

    @Override
    public String toString() {
        return "StudentSection{" +
                "studentSectionId=" + studentSectionId +
                ", studentName='" + studentName + '\'' +
                ", numberOfWeeks=" + numberOfWeeks +
                ", totalDaysOff=" + totalDaysOff +
                ", attended=" + attended +
                ", tmPercent=" + tmPercent +
                ", cancelledSession=" + cancelledSession +
                ", blockId=" + blockId +
                ", blockName='" + blockName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", numberOfWeeksCumul=" + numberOfWeeksCumul +
                ", totalDaysOffCumul=" + totalDaysOffCumul +
                ", attendedCumul=" + attendedCumul +
                ", bonus=" + bonus +
                ", extraPointCumul=" + extraPointCumul +
                ", cancelledSessionCumul=" + cancelledSessionCumul +
                ", tmPercentCumul=" + tmPercentCumul +
                //", totalDays=" + totalDays +
                '}';
    }
}
