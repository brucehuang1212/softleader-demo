package com.example.demo.dto;

import com.example.demo.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Data
public class LeaveRecordDto {

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

  @Schema(description = "請假天數")
  Integer leaveDays;

  @Schema(description = "請假小時數")
  Integer leaveHours;

  @Schema(description = "假別")
  LeaveType type;

  @Schema(description = "職務代理人")
  String officeAgent;

  @Schema(description = "代理項目")
  String agencyProject;

  @Schema(description = "職務代理人核可")
  YesNo officeAgentApproved;

  @Schema(description = "模組負責人")
  String moduleLeader;

  @Schema(description = "模組負責人核可")
  YesNo moduleLeaderApproved;

  @Schema(description = "專案經理")
  String projectManager;

  @Schema(description = "專案經理核可")
  YesNo projectManagerApproved;

  @Schema(description = "直屬主管")
  String supervisor;

  @Schema(description = "直屬主管核可")
  YesNo supervisorApproved;

  @Schema(description = "狀態")
  RecordStatus status;

  @Schema(description = "駁回原因")
  String rejectReason;

}
