package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.*;
import com.mum.edu.geek.exception.GeneralException;
import com.mum.edu.geek.service.ReportService;
import com.mum.edu.geek.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 6000)
public class ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value = "/attendances/entries", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentEntry> allEntries(
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findAllEntryStudentsReport();
    }

    @GetMapping(value = "/attendances/entries/{entryId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentEntry> getEntryStudents(
            @PathVariable Integer entryId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findEntryStudentsReport(entryId);
    }

    @GetMapping(value = "/attendances/sections/students", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentSection> allSections(
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findAllSectionStudentsReport();
    }

    @GetMapping(value = "/attendances/sections/students/{studentId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentSection> getStudent(
            @PathVariable Integer studentId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findByStudentIdReport(studentId);
    }

    @GetMapping(value = "/attendances/sections/students/{studentId}/cumul", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentSection getStudentCumul(
            @PathVariable Integer studentId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        List<StudentSection> list = reportService.findByStudentIdReport(studentId);

        if (list == null || list.isEmpty()) return null;

        return list.get(0);
    }

    @GetMapping(value = "/attendances/blocks/{blockId}/students", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentSection> getStudentBlock(
            @PathVariable Integer blockId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findByBlockIdReport(blockId);
    }

    @GetMapping(value = "/attendances/blocks/{blockId}/students/{studentId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentSection getStudentBlock(
            @PathVariable Integer studentId,
            @PathVariable Integer blockId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        List<StudentSection> list = reportService.findByStudentIdAndBlockIdReport(studentId, blockId);
        if (list == null || list.isEmpty()) return null;
        return list.get(0);
    }

    @GetMapping(value = "/attendances/faculties", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentFaculty> findAllFacultyStudentsReport(
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findAllFacultyStudentsReport();
    }

    @GetMapping(value = "/attendances/faculties/{facultyId}/students", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentFaculty> findByFacultyIdStudentsReport(
            @PathVariable Integer facultyId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findByFacultyIdStudentsReport(facultyId);
    }

    @GetMapping(value = "/attendances/faculties/{facultyId}/students/{studentId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentFaculty> findByFacultyIdAndStudentIdReport(
            @PathVariable Integer facultyId,
            @PathVariable Integer studentId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findByFacultyIdAndStudentIdReport(facultyId, studentId);
    }

    @GetMapping(value = "/attendances/details/{studentId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Reporting> findByStudentIdDetailsReport(
            @PathVariable Integer studentId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findByStudentIdDetailsReport(studentId);
    }

    @GetMapping(value = "/attendances/details/{studentId}/blocks/{blockId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Reporting> findByBlockAndStudentIdDetailsReport(
            @PathVariable Integer studentId,
            @PathVariable Integer blockId,
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return reportService.findByBlockAndStudentIdDetailsReport(studentId, blockId);
    }
}