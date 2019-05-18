package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.Attendance;
import com.mum.edu.geek.domain.Student;
import com.mum.edu.geek.repository.AttendanceRepository;
import com.mum.edu.geek.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public void saveAutoFile(List<String> fileLines) throws  Exception{
        fileLines.stream().forEach( line -> {

            String[] columns = line.split(",");

            String barCodeCol = columns[0];
            String dateCol = columns[1];
            String timeCol = columns[2];
            String locationCol = columns[3];

            List<Student> listStudent = this.studentRepository.findByBarCodeId(Long.parseLong(barCodeCol));

            if (!listStudent.isEmpty()) {
                Student student = listStudent.get(0);
                Attendance att = new Attendance(locationCol, student, dateCol, timeCol);
                try {
                    this.attendanceRepository.save(att);
                } catch (Exception ex){
                    // TODO HANDLE CONTRAINT EXCEPTION (DUPLICATE INSERTIONS COMING FROM FILE)
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    ex.printStackTrace();
                }

            }
        });
    }

    public void saveManualFile(List<String> fileLines) throws  Exception{
        fileLines.stream().forEach( line -> {

            String[] columns = line.split(",");
            String dateCol = columns[0];
            String studentCol = columns[1].replaceAll("-", "");

            Student student = this.studentRepository.getOne(Integer.parseInt(studentCol));

            if(student != null){
                Attendance att = new Attendance("DB", student, dateCol);
                try {
                    this.attendanceRepository.save(att);
                } catch (Exception ex){
                    // TODO HANDLE CONTRAINT EXCEPTION (DUPLICATE INSERTIONS COMING FROM FILE)
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    ex.printStackTrace();
                }
            }
        });

    }

}
