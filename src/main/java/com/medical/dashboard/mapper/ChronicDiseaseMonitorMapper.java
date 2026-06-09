package com.medical.dashboard.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.dashboard.entity.ChronicDiseaseMonitor;
import org.apache.ibatis.annotations.Mapper;

/**
 * 慢病随访监测 Mapper
 */
@Mapper
public interface ChronicDiseaseMonitorMapper extends BaseMapper<ChronicDiseaseMonitor> {
}
