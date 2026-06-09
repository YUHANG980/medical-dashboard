package com.medical.dashboard.service;

import com.medical.dashboard.entity.*;

import java.util.List;

/**
 * 数据大屏业务接口
 */
public interface DashboardService {

    /**
     * 查询疾病季节性趋势（按年份/月份筛选）
     */
    List<DiseaseSeasonalTrend> getDiseaseTrend(Integer year, Integer month);

    /**
     * 查询药品消耗预测（按年份/月份筛选）
     */
    List<DrugConsumptionForecast> getDrugForecast(Integer year, Integer month);

    /**
     * 查询科室工作量（按年份/月份筛选）
     */
    List<DepartmentWorkload> getDeptWorkload(Integer year, Integer month);

    /**
     * 查询区域疾病分布（按年份/月份筛选）
     */
    List<RegionalDiseaseDistribution> getRegionalDistribution(Integer year, Integer month);

    /**
     * 查询慢病随访监测（按年份/月份筛选）
     */
    List<ChronicDiseaseMonitor> getChronicMonitor(Integer year, Integer month);
}
