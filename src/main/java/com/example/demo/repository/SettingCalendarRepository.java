package com.example.demo.repository;

import com.example.demo.repository.entity.SettingCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SettingCalendarRepository extends JpaRepository<SettingCalendar, Long> {

    List<SettingCalendar> findByDateBetween(LocalDate beginDate, LocalDate endDate);

}
