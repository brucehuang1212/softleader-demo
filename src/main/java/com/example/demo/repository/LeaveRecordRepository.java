package com.example.demo.repository;

import com.example.demo.repository.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LeaveRecordRepository extends JpaRepository<LeaveRecord, Long> {

    List<LeaveRecord> findByOwnerAndBeginDateTimeBeforeAndEndDateTimeAfter(String owner, LocalDateTime dateTime1, LocalDateTime dateTime2);

    List<LeaveRecord> findByBeginDateTimeBeforeAndEndDateTimeAfter(LocalDateTime dateTime1, LocalDateTime dateTime2);

}
