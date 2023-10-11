package com.example.demo.service;

import com.example.demo.enums.*;
import com.example.demo.mapper.LeaveRecordMapper;
import com.example.demo.repository.*;
import com.example.demo.repository.entity.*;
import com.example.demo.request.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class LeaveRecordService {

    final LeaveRecordRepository repository;
    final LeaveRecordMapper mapper;
    final SettingCalendarRepository settingCalendarRepository;

    public LeaveRecord create(LeaveRecordCreateRequest request) {
        if (request.getBeginDateTime() == null || request.getEndDateTime() == null) {
            throw new IllegalArgumentException("假期起訖必須輸入");
        } else if (request.getBeginDateTime().isAfter(request.getEndDateTime())) {
            throw new IllegalArgumentException("假期起日必須大於訖日");
        } else if (repository.findByOwnerAndBeginDateTimeBeforeAndEndDateTimeAfter(request.getOwner(),
                request.getEndDateTime(), request.getBeginDateTime()).stream()
                .anyMatch(record -> record.getStatus() == RecordStatus.APPROVED)){
            throw new IllegalArgumentException("請假日期與其他假單重複，請重新選擇日期區間");
        }
        LeaveRecord entity = mapper.toEntity(request);
        this.calcLeaveDaysAndHours(entity);
        entity.setStatus(RecordStatus.APPROVAL);
        entity.setApplyDateTime(LocalDateTime.now());
        entity.setOfficeAgentApproved(YesNo.N);
        entity.setModuleLeaderApproved(YesNo.N);
        entity.setProjectManagerApproved(YesNo.N);
        entity.setSupervisorApproved(YesNo.N);
        return repository.save(entity);
    }

    public LeaveRecord replace(LeaveRecordReplaceRequest request) {
        LeaveRecord entity = repository.findById(request.getId()).orElseThrow(() -> new RuntimeException("查無假單資料"));
        if (request.getBeginDateTime() == null || request.getEndDateTime() == null) {
            throw new IllegalArgumentException("假期起訖必須輸入");
        } else if (request.getBeginDateTime().isAfter(request.getEndDateTime())) {
            throw new IllegalArgumentException("假期起日必須大於訖日");
        } else if (repository.findByOwnerAndBeginDateTimeBeforeAndEndDateTimeAfter(request.getOwner(),
                request.getEndDateTime(), request.getBeginDateTime()).stream()
                .anyMatch(record -> !record.getId().equals(request.getId()) && record.getStatus() == RecordStatus.APPROVED)){
            throw new IllegalArgumentException("請假日期與其他假單重複，請重新選擇日期區間");
        }

        mapper.toEntity(request, entity);
        return repository.save(entity);
    }

    private void calcLeaveDaysAndHours(LeaveRecord entity) {
        //請假天數排除假日
        List<SettingCalendar> calendars = settingCalendarRepository.findByDateBetween(entity.getBeginDateTime().toLocalDate(), entity.getEndDateTime().toLocalDate());
        entity.setLeaveDays((int) calendars.stream().filter(c -> c.getIsHoliday() == YesNo.N).count());

        if (entity.getBeginDateTime().getHour() == entity.getEndDateTime().getHour()) {
            entity.setLeaveHours(0);
        } else if (entity.getBeginDateTime().getHour() < entity.getEndDateTime().getHour()) {
            entity.setLeaveHours(entity.getEndDateTime().getHour() - entity.getBeginDateTime().getHour());
        } else {
            entity.setLeaveHours(24 + entity.getEndDateTime().getHour() - entity.getBeginDateTime().getHour());
        }
    }

}
