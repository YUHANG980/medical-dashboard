package com.medical.dashboard.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.dashboard.entity.DrugConsumptionForecast;
import org.apache.ibatis.annotations.Mapper;

/**
 * 药品消耗预测 Mapper
 */
@Mapper
public interface DrugConsumptionForecastMapper extends BaseMapper<DrugConsumptionForecast> {
}
