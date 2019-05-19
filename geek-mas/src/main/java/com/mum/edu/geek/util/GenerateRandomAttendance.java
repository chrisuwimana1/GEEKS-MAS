package com.mum.edu.geek.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GenerateRandomAttendance {
    public static void main(String[] args) throws Exception {
        LocalDate startDate = LocalDate.of(2019, 5, 27);
        LocalDate endDate = startDate.plusWeeks(4);

        List<LocalDate> attendandeDates = new ArrayList<>();
        while (startDate.isBefore(endDate)) {
            attendandeDates.add(startDate);
            startDate = startDate.plusDays(1);
        }

        System.out.println("attendandeDates = " + attendandeDates.size());

        String locs[] = {"DB", "AC"};
        String times[] = {"AM", "EAM"};

        Random random = new Random();

        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\celem\\OneDrive\\Desktop\\rc_data_0.txt"), true);

        for (int i = 10000000; i < 10000000 + 80; i++) {

            int n = i;

            List<LocalDate> stAttendance = new ArrayList<>();
            int j = random.nextInt(attendandeDates.size() - 20) + 20;
            System.out.println("j = " + j);
            for (int k = 0; k < j; k++) {
                LocalDate localDate = attendandeDates.get(random.nextInt(j));
                while (stAttendance.contains(localDate)) {
                    localDate = attendandeDates.get(random.nextInt(j));
                }

                stAttendance.add(localDate);
            }

            System.out.println("stAttendance = " + stAttendance.size());

            stAttendance.forEach(ld -> {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
                String line = n + "," + ld.format(formatter) + "," + times[random.nextInt(times.length)] + ",DB\n";
                try {
                    fos.write(line.getBytes());
                }catch (Exception ex){

                }

            });


        }

        fos.close();
    }
}
