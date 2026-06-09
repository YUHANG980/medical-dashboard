package com.medical.dashboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 药品消耗预测
 * 对应 MySQL 表: drug_consumption_forecast
 */
@Data
@TableName("drug_consumption_forecast")
public class DrugConsumptionForecast {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 药品名称 */
    private String drugName;

    /** 药品类别 */
    private String drugCategory;

    /** 年份 */
    private Integer statYear;

    /** 月份 */
    private Integer statMonth;

    /** 实际消耗量 */
    private Integer actualQty;

    /** 预测消耗量 */
    private Integer forecastQty;

    /** 库存预警 0/1 */
    private Integer stockAlert;
}
