package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.StudentFaculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentFacultyRepository extends JpaRepository<StudentFaculty, Integer> {
    List<StudentFaculty> findByFacultyId(Integer facultyId);
    List<StudentFaculty> findByFacultyIdAndStudentId(Integer facultyId, Integer studentId);
}
