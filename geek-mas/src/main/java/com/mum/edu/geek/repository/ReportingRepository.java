package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.Reporting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportingRepository extends JpaRepository<Reporting, Integer> {
    @Query(value = "select r from Reporting r where r.reportingId.studentId = :studentId and r.attendanceType = 'IN_BLOCK'")
    List<Reporting> findReportingByStudentId(Integer studentId);
    @Query(value = "select r from Reporting r where r.reportingId.studentId = :studentId and r.attendanceType = 'IN_BLOCK' and r.blockId = :blockId order by r.reportingId.attendanceDate")
    List<Reporting> findReportingByBlockAndStudentId(Integer studentId, Integer blockId);
}