package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.StudentSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentSectionRepository extends JpaRepository<StudentSection, Integer> {
    @Query(value = "select ss from StudentSection ss where ss.studentSectionId.studentId = :studentId")
    public List<StudentSection> findByStudentId(Integer studentId);
    public List<StudentSection> findByBlockId(Integer blockId);
    @Query(value = "select ss from StudentSection ss where ss.studentSectionId.studentId = :studentId and ss.blockId = :blockId")
    public List<StudentSection> findByStudentIdAndBlockId(Integer studentId, Integer blockId);
}