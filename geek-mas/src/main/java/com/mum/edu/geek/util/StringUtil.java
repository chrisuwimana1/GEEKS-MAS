package com.mum.edu.geek.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class String2Object {


    public static Object parse(String fileLine){

        String[] columns = fileLine.split(",");


        LocalDate.parse(columns[1], DateTimeFormatter.ofPattern("mm/dd/yyyy"));

        return null;
    }

}
