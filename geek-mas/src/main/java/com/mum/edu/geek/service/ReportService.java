package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.*;
import com.mum.edu.geek.repository.ReportingRepository;
import com.mum.edu.geek.repository.StudentEntryReportRepository;
import com.mum.edu.geek.repository.StudentFacultyRepository;
import com.mum.edu.geek.repository.StudentSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private StudentEntryReportRepository ser;
    @Autowired
    private StudentFacultyRepository sfr;
    @Autowired
    private StudentSectionRepository ssr;
    @Autowired
    private ReportingRepository reportingRepository;

    public List<StudentEntry> findAllEntryStudentsReport() {
        return ser.findAll();
    }

    public List<StudentEntry> findEntryStudentsReport(Integer entryId) {
        return ser.findByEntryId(entryId);
    }

    public List<StudentSection> findAllSectionStudentsReport() {
        return ssr.findAll();
    }

    public List<StudentSection> findByStudentIdReport(Integer studentId) {
        return ssr.findByStudentId(studentId);
    }

    public List<StudentSection> findByBlockIdReport(Integer blockId) {
        return ssr.findByBlockId(blockId);
    }

    public List<StudentSection> findByStudentIdAndBlockIdReport(Integer studentId, Integer blockId) {
        return ssr.findByStudentIdAndBlockId(studentId, blockId);
    }

    public List<StudentFaculty> findAllFacultyStudentsReport() {
        return sfr.findAll();
    }

    public List<StudentFaculty> findByFacultyIdStudentsReport(Integer facultyId) {
        return sfr.findByFacultyId(facultyId);
    }

    public List<StudentFaculty> findByFacultyIdAndStudentIdReport(Integer facultyId, Integer studentId) {
        return sfr.findByFacultyIdAndStudentId(facultyId, studentId);
    }

    public List<Reporting> findByStudentIdDetailsReport(Integer studentId) {
        List<Reporting> list = reportingRepository.findReportingByStudentId(studentId);
        return list;
    }

    public List<Reporting> findByBlockAndStudentIdDetailsReport(Integer studentId, Integer blockId) {
        List<Reporting> list = reportingRepository.findReportingByBlockAndStudentId(studentId, blockId);
        return list;
    }
}