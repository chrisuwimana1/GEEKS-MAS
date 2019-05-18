package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.StudentEntry;
import com.mum.edu.geek.domain.StudentFaculty;
import com.mum.edu.geek.domain.StudentSection;
import com.mum.edu.geek.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<StudentEntry> findAllEntryStudentsReport() {
        return reportRepository.findAllEntryStudentsReport();
    }

    public List<StudentEntry> findEntryStudentsReport(Integer entryId) {
        return reportRepository.findByEntryIdStudentsReport(entryId);
    }

    public List<StudentSection> findAllSectionStudentsReport() {
        return reportRepository.findAllSectionStudentsReport();
    }

    public List<StudentSection> findByStudentIdReport(Integer studentId) {
        return reportRepository.findByStudentIdReport(studentId);
    }

    public List<StudentSection> findByStudentIdAndBlockIdReport(Integer studentId, Integer blockId) {
        return reportRepository.findByStudentIdAndBlockIdReport(studentId, blockId);
    }

    public List<StudentFaculty> findAllFacultyStudentsReport() {
        return reportRepository.findAllFacultyStudentsReport();
    }

    public List<StudentFaculty> findByFacultyIdStudentsReport(Integer facultyId) {
        return reportRepository.findByFacultyIdStudentsReport(facultyId);
    }

    public List<StudentFaculty> findByFacultyIdAndStudentIdReport(Integer facultyId, Integer studentId) {
        return reportRepository.findByFacultyIdAndStudentIdReport(facultyId, studentId);
    }
}
