package com.example.demo.request;

import com.example.demo.enums.LeaveType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "請假紀錄")
public class LeaveRecordReplaceRequest {

  @Schema(description = "ID")
  Long id;

  @Schema(description = "請假人員")
  String owner;

  @Schema(description = "申請日期")
  LocalDateTime applyDateTime;

  @Schema(description = "請假起始日期")
  LocalDateTime beginDateTime;

  @Schema(description = "請假結束日期")
  LocalDateTime endDateTime;

  @Schema(description = "假別")
  LeaveType type;

  @Schema(description = "職務代理人")
  String officeAgent;

  @Schema(description = "代理項目")
  String agencyProject;

  @Schema(description = "模組負責人")
  String moduleLeader;

  @Schema(description = "專案經理")
  String projectManager;

  @Schema(description = "直屬主管")
  String supervisor;

}
