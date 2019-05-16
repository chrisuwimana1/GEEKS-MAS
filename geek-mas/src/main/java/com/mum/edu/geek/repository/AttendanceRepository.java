package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository  extends JpaRepository<Attendance,Long> {
}
