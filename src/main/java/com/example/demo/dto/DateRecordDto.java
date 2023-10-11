package com.example.demo.dto;

import lombok.*;

import java.time.*;
import java.util.List;

@Data
public class DateRecordDto {

  private LocalDate date;

  private List<LeaveDto> leaves;

}
