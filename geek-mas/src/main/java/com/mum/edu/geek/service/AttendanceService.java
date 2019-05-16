package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.Attendance;
import com.mum.edu.geek.domain.Location;
import com.mum.edu.geek.domain.Student;
import com.mum.edu.geek.repository.AttendanceRepository;
import com.mum.edu.geek.repository.LocationRepository;
import com.mum.edu.geek.repository.StudentRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;


    @Transactional
    public void save(List<String> fileLines){
        fileLines.stream().forEach( line -> {

            String[] columns = line.split(",");
            String barCodeCol = columns[0];
            String dateCol = columns[1];
            String timeCol = columns[2];
            String locationCol = columns[3];


            Location location = this.locationRepository.findByLocation(locationCol).get(0);
            Student student = this.studentRepository.findByBarCodeId(Long.parseLong(barCodeCol)).get(0);

            Attendance att = new Attendance(location,student,dateCol,timeCol);

            this.attendanceRepository.save(att);
        });

    }

}
