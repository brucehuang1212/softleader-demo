package com.example.demo.repository.entity;

import com.example.demo.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.*;

@Entity
@Table(name = "LEAVE_RECORD", schema = "DEMO")
@Data
@Comment("請假紀錄")
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLeaveRecord")
  @SequenceGenerator(name = "seqLeaveRecord", sequenceName = "DEMO.LEAVE_RECORD_SEQ", allocationSize = 1, initialValue = 1)
  @Comment("ID")
  @Column(name = "ID")
  Long id;

  @Comment("請假人員")
  @Column(name = "OWNER")
  String owner;

  @Comment("申請日期")
  @Column(name = "APPLY_DATE_TIME")
  LocalDateTime applyDateTime;

  @Comment("請假起始日期")
  @Column(name = "BEGIN_DATE_TIME")
  LocalDateTime beginDateTime;

  @Comment("請假結束日期")
  @Column(name = "END_DATE_TIME")
  LocalDateTime endDateTime;

  @Comment("請假天數")
  @Column(name = "LEAVE_DAYS")
  Integer leaveDays;

  @Comment("請假小時數")
  @Column(name = "LEAVE_HOURS")
  Integer leaveHours;

  @Comment("假別")
  @Column(name = "TYPE")
  @Enumerated(EnumType.STRING)
  LeaveType type;

  @Comment("職務代理人")
  @Column(name = "OFFICE_AGENT")
  String officeAgent;

  @Comment("代理項目")
  @Column(name = "AGENCY_PROJECT")
  String agencyProject;

  @Comment("職務代理人核可")
  @Column(name = "OFFICE_AGENT_APPROVED")
  @Enumerated(EnumType.STRING)
  YesNo officeAgentApproved;

  @Comment("模組負責人")
  @Column(name = "MODULE_LEADER")
  String moduleLeader;

  @Comment("模組負責人核可")
  @Column(name = "MODULE_LEADER_APPROVED")
  @Enumerated(EnumType.STRING)
  YesNo moduleLeaderApproved;

  @Comment("專案經理")
  @Column(name = "PROJECT_MANAGER")
  String projectManager;

  @Comment("專案經理核可")
  @Column(name = "PROJECT_MANAGER_APPROVED")
  @Enumerated(EnumType.STRING)
  YesNo projectManagerApproved;

  @Comment("直屬主管")
  @Column(name = "SUPERVISOR")
  String supervisor;

  @Comment("直屬主管核可")
  @Column(name = "SUPERVISOR_APPROVED")
  @Enumerated(EnumType.STRING)
  YesNo supervisorApproved;

  @Comment("狀態")
  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  RecordStatus status;

  @Comment("駁回原因")
  @Column(name = "REJECT_REASON")
  String rejectReason;

}
