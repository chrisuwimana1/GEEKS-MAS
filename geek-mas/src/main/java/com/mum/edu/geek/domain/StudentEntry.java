package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
public class StudentEntry implements Serializable {
    @Id
    private Integer studentId;
    private String studentName;
    private Integer possible;
    private Integer attended;
    private Integer entryId;
    private Integer cancelledSession;



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

}
