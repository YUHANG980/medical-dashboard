package com.medical.dashboard.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.medical.dashboard.entity.*;
import com.medical.dashboard.mapper.*;
import com.medical.dashboard.service.DashboardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据大屏业务实现
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Resource
    private DiseaseSeasonalTrendMapper diseaseTrendMapper;

    @Resource
    private DrugConsumptionForecastMapper drugForecastMapper;

    @Resource
    private DepartmentWorkloadMapper deptWorkloadMapper;

    @Resource
    private RegionalDiseaseDistributionMapper regionalDistMapper;

    @Resource
    private ChronicDiseaseMonitorMapper chronicMonitorMapper;

    @Override
    public List<DiseaseSeasonalTrend> getDiseaseTrend(Integer year, Integer month) {
        LambdaQueryWrapper<DiseaseSeasonalTrend> wrapper = new LambdaQueryWrapper<>();
        if (year != null) {
            wrapper.eq(DiseaseSeasonalTrend::getStatYear, year);
        }
        if (month != null) {
            wrapper.eq(DiseaseSeasonalTrend::getStatMonth, month);
        }
        wrapper.orderByAsc(DiseaseSeasonalTrend::getStatYear, DiseaseSeasonalTrend::getStatMonth);
        return diseaseTrendMapper.selectList(wrapper);
    }

    @Override
    public List<DrugConsumptionForecast> getDrugForecast(Integer year, Integer month) {
        LambdaQueryWrapper<DrugConsumptionForecast> wrapper = new LambdaQueryWrapper<>();
        if (year != null) {
            wrapper.eq(DrugConsumptionForecast::getStatYear, year);
        }
        if (month != null) {
            wrapper.eq(DrugConsumptionForecast::getStatMonth, month);
        }
        wrapper.orderByAsc(DrugConsumptionForecast::getStatYear, DrugConsumptionForecast::getStatMonth);
        return drugForecastMapper.selectList(wrapper);
    }

    @Override
    public List<DepartmentWorkload> getDeptWorkload(Integer year, Integer month) {
        LambdaQueryWrapper<DepartmentWorkload> wrapper = new LambdaQueryWrapper<>();
        if (year != null) {
            wrapper.eq(DepartmentWorkload::getStatYear, year);
        }
        if (month != null) {
            wrapper.eq(DepartmentWorkload::getStatMonth, month);
        }
        wrapper.orderByAsc(DepartmentWorkload::getRankInMonth);
        return deptWorkloadMapper.selectList(wrapper);
    }

    @Override
    public List<RegionalDiseaseDistribution> getRegionalDistribution(Integer year, Integer month) {
        LambdaQueryWrapper<RegionalDiseaseDistribution> wrapper = new LambdaQueryWrapper<>();
        if (year != null) {
            wrapper.eq(RegionalDiseaseDistribution::getStatYear, year);
        }
        if (month != null) {
            wrapper.eq(RegionalDiseaseDistribution::getStatMonth, month);
        }
        wrapper.orderByDesc(RegionalDiseaseDistribution::getVisitCount);
        return regionalDistMapper.selectList(wrapper);
    }

    @Override
    public List<ChronicDiseaseMonitor> getChronicMonitor(Integer year, Integer month) {
        LambdaQueryWrapper<ChronicDiseaseMonitor> wrapper = new LambdaQueryWrapper<>();
        if (year != null) {
            wrapper.eq(ChronicDiseaseMonitor::getStatYear, year);
        }
        if (month != null) {
            wrapper.eq(ChronicDiseaseMonitor::getStatMonth, month);
        }
        wrapper.orderByAsc(ChronicDiseaseMonitor::getStatYear, ChronicDiseaseMonitor::getStatMonth);
        return chronicMonitorMapper.selectList(wrapper);
    }
}
