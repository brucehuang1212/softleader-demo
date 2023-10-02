package com.example.demo.repository.entity;

import com.example.demo.enums.YesNo;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SETTING_CALENDAR", schema = "DEMO")
@Data
@Comment("日曆設定檔")
@NoArgsConstructor
@AllArgsConstructor
public class SettingCalendar {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSettingCalendar")
  @SequenceGenerator(name = "seqSettingCalendar", sequenceName = "ADP.SEQ_SETTING_CALENDAR", allocationSize = 1)
  @Comment("ID")
  @Column(name = "ID")
  Long id;

  @Comment("日期")
  @Column(name = "DATE")
  LocalDate date;

  @Comment("日期")
  @Column(name = "IS_HOLIDAY")
  YesNo isHoliday;

  @Comment("名稱")
  @Column(name = "DESC")
  String desc;

}
