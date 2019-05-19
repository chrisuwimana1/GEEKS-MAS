package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.Attendance;
import com.mum.edu.geek.domain.Student;
import com.mum.edu.geek.repository.AttendanceRepository;
import com.mum.edu.geek.repository.LocationRepository;
import com.mum.edu.geek.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;


    //@Transactional
    public void saveAutoFile(List<String> fileLines) throws Exception {
        List<Attendance> list=new ArrayList<>();
        fileLines.stream().forEach(line -> {

            String[] columns = line.split(",");

            String barCodeCol = columns[0];
            String dateCol = columns[1];
            String timeCol = columns[2];
            String locationCol = columns[3];

//            TempAttendance att = new TempAttendance(dateCol, timeCol, Integer.parseInt(barCodeCol), locationCol);
//            list.add(att);
////            try {
//                this.attendanceRepository.save(att);
////            } catch (Exception ex) {
////                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
////                //ex.printStackTrace();
////            }


        });

        System.out.println("Start = " + new Date());
        //attendanceRepository.saveAll(list);
        System.out.println("End = " + new Date());
    }

    @Transactional
    public void saveManualFile(List<String> fileLines) throws Exception {
        fileLines.stream().forEach(line -> {

            String[] columns = line.split(",");
            String dateCol = columns[0];
            String studentCol = columns[1].replaceAll("-", "");

            Student student = this.studentRepository.getOne(Integer.parseInt(studentCol));

            Attendance att = new Attendance("DB", student, dateCol);
            //this.attendanceRepository.save(att);

        });

    }

}
