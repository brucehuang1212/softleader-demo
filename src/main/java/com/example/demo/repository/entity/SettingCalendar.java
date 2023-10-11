package com.example.demo.repository.entity;

import com.example.demo.enums.YesNo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

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
  @SequenceGenerator(name = "seqSettingCalendar", sequenceName = "DEMO.SETTING_CALENDAR_SEQ", allocationSize = 1, initialValue = 1)
  @Comment("ID")
  @Column(name = "ID")
  Long id;

  @Comment("日期")
  @Column(name = "DATE")
  LocalDate date;

  @Comment("是否為假日")
  @Column(name = "IS_HOLIDAY")
  @Enumerated(EnumType.STRING)
  YesNo isHoliday;

  @Comment("日期備註")
  @Column(name = "DESC")
  String desc;

}
