package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.enums.*;
import com.example.demo.repository.*;
import com.example.demo.repository.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class SettingCalendarService {

    final SettingCalendarRepository repository;
    final LeaveRecordRepository leaveRecordRepository;

    public MonthRecordDto getRecordByMonth(YearMonth yearMonth) {
        MonthRecordDto monthRecordDto = new MonthRecordDto();
        List<LeaveRecord> leaveRecords = leaveRecordRepository.findByBeginDateTimeBeforeAndEndDateTimeAfter(yearMonth.atDay(1).atStartOfDay(),
                yearMonth.atEndOfMonth().atTime(LocalTime.MAX)).stream()
                .filter(leaveRecord -> leaveRecord.getStatus() == RecordStatus.APPROVED)
                .toList();
        List<DateRecordDto> dates = repository.findByDateBetween(yearMonth.atDay(1), yearMonth.atEndOfMonth()).stream()
            .map(settingCalendar ->  {
                DateRecordDto dateRecordDto = new DateRecordDto();
                dateRecordDto.setDate(settingCalendar.getDate());
                List<LeaveDto> leaves = new ArrayList<>();
                if (settingCalendar.getIsHoliday() == YesNo.N) {
                    leaves.addAll(leaveRecords.stream()
                        .filter(leaveRecord -> !settingCalendar.getDate().isBefore(leaveRecord.getBeginDateTime().toLocalDate()))
                        .filter(leaveRecord -> !settingCalendar.getDate().isAfter(leaveRecord.getEndDateTime().toLocalDate()))
                        .map(leaveRecord -> new LeaveDto(leaveRecord.getOwner(), leaveRecord.getType())).toList());
                }
                dateRecordDto.setLeaves(leaves);
                return dateRecordDto;
            }).toList();
        monthRecordDto.setDates(dates);
        return monthRecordDto;
    }

}
