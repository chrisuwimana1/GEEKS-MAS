package com.mum.edu.geek.domain;

import java.time.LocalDate;

public class AttendanceItem {
    LocalDate date;
    Boolean attended;

    public AttendanceItem(LocalDate date, Boolean attended) {
        this.date = date;
        this.attended = attended;
    }
}