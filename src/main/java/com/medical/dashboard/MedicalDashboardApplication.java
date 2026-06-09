package com.medical.dashboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 智慧医疗数据分析与居民健康监测系统
 * Spring Boot 启动类
 */
@SpringBootApplication
@MapperScan("com.medical.dashboard.mapper")
public class MedicalDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalDashboardApplication.class, args);
        System.out.println("========================================");
        System.out.println("  智慧医疗数据大屏后端服务已启动");
        System.out.println("  API 地址: http://localhost:8090");
        System.out.println("========================================");
    }
}
