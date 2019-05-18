package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.StudentEntry;
import com.mum.edu.geek.domain.StudentFaculty;
import com.mum.edu.geek.domain.StudentSection;
import com.mum.edu.geek.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/student_entries", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentEntry> allEntries() {
        return reportService.findAllEntryStudentsReport();
    }

    @GetMapping(value = "/student_entries/{entryId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentEntry> getEntryStudents(@PathVariable Integer entryId) {
        return reportService.findEntryStudentsReport(entryId);
    }

    @GetMapping(value = "/section_students", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentSection> allSections() {
        return reportService.findAllSectionStudentsReport();
    }

    @GetMapping(value = "/section_students/{studentId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentSection> getStudent(@PathVariable Integer studentId) {
        return reportService.findByStudentIdReport(studentId);
    }

    @GetMapping(value = "/student_blocks/{blockId}/students/{studentId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentSection> getStudentBlock(@PathVariable Integer studentId, @PathVariable Integer blockId) {
        return reportService.findByStudentIdAndBlockIdReport(studentId, blockId);
    }

    @GetMapping(value = "/faculty_students", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentFaculty> findAllFacultyStudentsReport() {
        return reportService.findAllFacultyStudentsReport();
    }

    @GetMapping(value = "/student_faculties/{facultyId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentFaculty> findByFacultyIdStudentsReport(@PathVariable Integer facultyId) {
        return reportService.findByFacultyIdStudentsReport(facultyId);
    }

    @GetMapping(value = "/student_faculties/{facultyId}/students/{studentId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentFaculty> findByFacultyIdAndStudentIdReport(@PathVariable Integer facultyId,@PathVariable  Integer studentId) {
        return reportService.findByFacultyIdAndStudentIdReport(facultyId, studentId);
    }
}