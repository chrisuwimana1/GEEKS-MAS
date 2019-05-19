package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.StudentEntry;
import com.mum.edu.geek.domain.StudentFaculty;
import com.mum.edu.geek.domain.StudentSection;
import com.mum.edu.geek.repository.StudentEntryReportRepository;
import com.mum.edu.geek.repository.StudentFacultyRepository;
import com.mum.edu.geek.repository.StudentSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private StudentEntryReportRepository ser;
    @Autowired
    private StudentFacultyRepository sfr;
    @Autowired
    private StudentSectionRepository ssr;

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
}