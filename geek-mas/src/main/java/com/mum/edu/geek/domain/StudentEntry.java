package com.mum.edu.geek.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

@Entity
public class StudentEntry implements Serializable {
    @Id
    private Integer studentId;
    private String studentName;
    private Integer numberOfWeeks;
    private Integer totalDaysOff;
    private Integer attended;
    private Integer entryId;
    private String entryName;
    private Integer cancelledSession;
    private BigDecimal tmPercent;
    @Column(name = "extra_point_days")
    private Integer requiredDays;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(Integer possible) {
        this.numberOfWeeks = possible;
    }

    public Integer getAttended() {
        return attended;
    }

    public void setAttended(Integer attended) {
        this.attended = attended;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getCancelledSession() {
        return cancelledSession;
    }

    public void setCancelledSession(Integer cancelledSession) {
        this.cancelledSession = cancelledSession;
    }

    public Integer getTotalDaysOff() {
        return totalDaysOff;
    }

    public void setTotalDaysOff(Integer totalDaysOff) {
        this.totalDaysOff = totalDaysOff;
    }

    public BigDecimal getTmPercent() {
        return tmPercent.round(new MathContext(3));
    }

    public void setTmPercent(BigDecimal tmPercent) {
        this.tmPercent = tmPercent;
    }

    public Integer getTotalPossibleDays() {
        return getNumberOfWeeks() * 6 - getCancelledSession();
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public Integer getRequiredDays() {
        return requiredDays;
    }

    public void setRequiredDays(Integer extraPointDays) {
        this.requiredDays = extraPointDays;
    }
}
