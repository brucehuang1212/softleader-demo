package com.example.demo.dto;

import com.example.demo.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveDto {

  @Schema(description = "請假人員")
  String owner;

  @Schema(description = "假別")
  LeaveType type;

}
