package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.StudentEntry;
import com.mum.edu.geek.domain.StudentFaculty;
import com.mum.edu.geek.domain.StudentSection;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReportRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<StudentEntry> findAllEntryStudentsReport() {
        return entityManager.createQuery("SELECT se FROM StudentEntry se",StudentEntry.class).getResultList();
    }

    public List<StudentEntry> findByEntryIdStudentsReport(Integer entryId) {
        return entityManager.createQuery("SELECT se FROM StudentEntry se WHERE se.entryId = '" + entryId + "'",StudentEntry.class).getResultList();
    }

    public List<StudentSection> findAllSectionStudentsReport() {
        return entityManager.createQuery("SELECT ss FROM StudentSection ss", StudentSection.class).getResultList();
    }

    public List<StudentSection> findByStudentIdReport(Integer studentId) {
        return entityManager.createQuery("SELECT ss FROM StudentSection ss WHERE ss.studentId = '" + studentId + "'",StudentSection.class).getResultList();
    }

    public List<StudentSection> findByStudentIdAndBlockIdReport(Integer studentId, Integer blockId) {
        return entityManager.createQuery("SELECT ss FROM StudentSection ss WHERE ss.studentId = '" + studentId + "' AND ss.blockId = '" + blockId + "'", StudentSection.class).getResultList();
    }

    public List<StudentFaculty> findAllFacultyStudentsReport() {
        return entityManager.createQuery("SELECT sf FROM StudentFaculty sf").getResultList();
    }

    public List<StudentFaculty> findByFacultyIdStudentsReport(Integer facultyId) {
        return entityManager.createQuery("SELECT sf FROM StudentFaculty sf WHERE sf.facultyId = '" + facultyId + "'", StudentFaculty.class).getResultList();
    }

    public List<StudentFaculty> findByFacultyIdAndStudentIdReport(Integer facultyId, Integer studentId) {
        return entityManager.createQuery("SELECT sf FROM StudentFaculty sf WHERE sf.facultyId = '" + facultyId + "' AND sf.studentId = '" + studentId + "'", StudentFaculty.class).getResultList();
    }
}