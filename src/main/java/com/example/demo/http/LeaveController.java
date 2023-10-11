/*
ADPM-269 AUDIT_LOG 新增USER 登入IP
ADPM-288 by Jade 應付未付Ｂ檔
*/
package com.example.demo.http;

import com.example.demo.dto.MonthRecordDto;
import com.example.demo.repository.entity.*;
import com.example.demo.request.*;
import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
class LeaveController {

  @Autowired
  private LeaveRecordService leaveRecordService;
  @Autowired
  private SettingCalendarService calendarService;

  @PostMapping("/record/create")
  public LeaveRecord createRecord(LeaveRecordCreateRequest request) {
    return leaveRecordService.create(request);
  }

  @PostMapping("/record/replace")
  public LeaveRecord repleaceRecord(LeaveRecordReplaceRequest request) {
    return leaveRecordService.replace(request);
  }

  @PostMapping("/calendar/create")
  public MonthRecordDto getRecordByMonth(YearMonth yearMonth) {
    return calendarService.getRecordByMonth(yearMonth);
  }



}
