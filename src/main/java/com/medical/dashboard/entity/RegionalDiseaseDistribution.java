package com.medical.dashboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 区域疾病分布
 * 对应 MySQL 表: regional_disease_distribution
 */
@Data
@TableName("regional_disease_distribution")
public class RegionalDiseaseDistribution {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 年份 */
    private Integer statYear;

    /** 月份 */
    private Integer statMonth;

    /** 区域名称 */
    private String region;

    /** 疾病大类 */
    private String diseaseCategory;

    /** 就诊人次 */
    private Integer visitCount;

    /** 每万人就诊率 */
    private BigDecimal populationRatio;
}
