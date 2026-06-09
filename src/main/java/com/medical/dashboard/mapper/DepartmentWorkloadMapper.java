package com.medical.dashboard.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.dashboard.entity.DepartmentWorkload;
import org.apache.ibatis.annotations.Mapper;

/**
 * 科室工作量 Mapper
 */
@Mapper
public interface DepartmentWorkloadMapper extends BaseMapper<DepartmentWorkload> {
}
