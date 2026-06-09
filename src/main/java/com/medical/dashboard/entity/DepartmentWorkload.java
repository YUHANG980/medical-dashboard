package com.medical.dashboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 科室工作量
 * 对应 MySQL 表: department_workload
 */
@Data
@TableName("department_workload")
public class DepartmentWorkload {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 年份 */
    private Integer statYear;

    /** 月份 */
    private Integer statMonth;

    /** 科室名称 */
    private String department;

    /** 就诊人次 */
    private Integer visitCount;

    /** 平均候诊时长(分钟) */
    private BigDecimal avgWaitMin;

    /** 当月排名 */
    private Integer rankInMonth;
}
