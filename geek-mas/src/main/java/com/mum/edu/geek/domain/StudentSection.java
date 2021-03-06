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
    @Column(name = "EXTRA_POINT_DAYS")
    private Integer requiredAttended;
    private BigDecimal tmPercent;
    private Integer cancelledSession;
    private Integer blockId;
    private String blockName;
    private String courseId;
    private String courseName;
    private Integer numberOfWeeksCumul;
    private Integer totalDaysOffCumul;
    private Integer attendedCumul;
    @Column(name = "EXTRA_POINT_DAY_CUMUL")
    private Integer requiredAttendedCumul;
    @Column(name = "extra_point")
    private BigDecimal bonusPoints;
    @Column(name = "extra_point_cumul")
    private BigDecimal bonusPointsCumul;
    private Integer cancelledSessionCumul;//EXTRA_POINT_DAYS
    private BigDecimal tmPercentCumul;


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

    public BigDecimal geExtraPointCumul() {
        return bonusPointsCumul;
    }

    public void setStudentSectionId(StudentSectionId studentSectionId) {
        this.studentSectionId = studentSectionId;
    }

    public void setTmPercent(BigDecimal tmPercent) {
        this.tmPercent = tmPercent;
    }

    public void setBonusPointsCumul(BigDecimal extraPointCumul) {
        this.bonusPointsCumul = extraPointCumul;
    }

    public void setTmPercentCumul(BigDecimal tmPercentCumul) {
        this.tmPercentCumul = tmPercentCumul;
    }

    public BigDecimal getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(BigDecimal bonus) {
        this.bonusPoints = bonus;
    }

    public BigDecimal getBonusPointsCumul() {
        return bonusPointsCumul;
    }

    public Integer getRequiredAttended() {
        return requiredAttended;
    }

    public void setRequiredAttended(Integer requiredAttended) {
        this.requiredAttended = requiredAttended;
    }

    public Integer getRequiredAttendedCumul() {
        return requiredAttendedCumul;
    }

    public void setRequiredAttendedCumul(Integer requiredAttendedCumul) {
        this.requiredAttendedCumul = requiredAttendedCumul;
    }
}