package com.medical.dashboard.controller;

import com.medical.dashboard.entity.*;
import com.medical.dashboard.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 智慧医疗数据大屏 REST API
 * 提供 5 个数据接口，对应 5 张业务表
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class DashboardController {

    @Resource
    private DashboardService dashboardService;

    /**
     * 1. 疾病季节性趋势
     * GET /api/disease/trend?year=2025&month=6
     */
    @GetMapping("/disease/trend")
    public Result<List<DiseaseSeasonalTrend>> getDiseaseTrend(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) {
        List<DiseaseSeasonalTrend> data = dashboardService.getDiseaseTrend(year, month);
        return Result.ok(data);
    }

    /**
     * 2. 药品消耗预测
     * GET /api/drug/forecast?year=2025&month=6
     */
    @GetMapping("/drug/forecast")
    public Result<List<DrugConsumptionForecast>> getDrugForecast(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) {
        List<DrugConsumptionForecast> data = dashboardService.getDrugForecast(year, month);
        return Result.ok(data);
    }

    /**
     * 3. 科室工作量
     * GET /api/dept/workload?year=2025&month=6
     */
    @GetMapping("/dept/workload")
    public Result<List<DepartmentWorkload>> getDeptWorkload(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) {
        List<DepartmentWorkload> data = dashboardService.getDeptWorkload(year, month);
        return Result.ok(data);
    }

    /**
     * 4. 区域疾病分布
     * GET /api/regional/distribution?year=2025&month=6
     */
    @GetMapping("/regional/distribution")
    public Result<List<RegionalDiseaseDistribution>> getRegionalDistribution(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) {
        List<RegionalDiseaseDistribution> data = dashboardService.getRegionalDistribution(year, month);
        return Result.ok(data);
    }

    /**
     * 5. 慢病随访监测
     * GET /api/chronic/monitor?year=2025&month=6
     */
    @GetMapping("/chronic/monitor")
    public Result<List<ChronicDiseaseMonitor>> getChronicMonitor(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) {
        List<ChronicDiseaseMonitor> data = dashboardService.getChronicMonitor(year, month);
        return Result.ok(data);
    }
}
