package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.StudentEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentEntryReportRepository extends JpaRepository<StudentEntry, Integer> {
    List<StudentEntry> findByEntryId(Integer entryId);
}