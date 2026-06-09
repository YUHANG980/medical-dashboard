package com.medical.dashboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 疾病季节性趋势
 * 对应 MySQL 表: disease_seasonal_trend
 */
@Data
@TableName("disease_seasonal_trend")
public class DiseaseSeasonalTrend {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 年份 */
    private Integer statYear;

    /** 月份 */
    private Integer statMonth;

    /** 季节（春/夏/秋/冬） */
    private String season;

    /** 疾病大类 */
    private String diseaseCategory;

    /** 就诊人次 */
    private Integer visitCount;

    /** 同比增长率(%) */
    @TableField("yoy_growth_pct")
    private BigDecimal yoyGrowth;
}
