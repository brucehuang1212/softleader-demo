package com.example.demo.dto;

import lombok.*;

import java.time.*;
import java.util.List;

@Data
public class MonthRecordDto {

  private Month month;

  private List<DateRecordDto> dates;

}
