package com.example.demo.repository.entity;

import com.example.demo.enums.LeaveType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "LEAVE_RECORD", schema = "DEMO")
@Data
@Comment("請假紀錄")
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLeaveRecord")
  @SequenceGenerator(name = "seqLeaveRecord", sequenceName = "ADP.SEQ_LEAVE_RECORD", allocationSize = 1)
  @Comment("ID")
  @Column(name = "ID")
  Long id;

  @Comment("日期")
  @Column(name = "DATE")
  LocalDate date;

  @Comment("假別")
  @Column(name = "TYPE")
  LeaveType type;

}
