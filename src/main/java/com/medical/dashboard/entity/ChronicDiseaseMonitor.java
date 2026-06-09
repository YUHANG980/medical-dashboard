package com.medical.dashboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 慢病随访监测
 * 对应 MySQL 表: chronic_disease_monitor
 */
@Data
@TableName("chronic_disease_monitor")
public class ChronicDiseaseMonitor {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 年份 */
    private Integer statYear;

    /** 月份 */
    private Integer statMonth;

    /** 慢病名称 */
    private String diseaseName;

    /** 在管患者数 */
    private Integer totalPatients;

    /** 已完成随访数 */
    private Integer followupCount;

    /** 随访率(%) */
    private BigDecimal followupRate;

    /** 控制达标率(%) */
    private BigDecimal controlRate;
}
