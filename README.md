# 🏥 智慧医疗数据分析与居民健康监测平台

基于 Hadoop HA 高可用集群的医疗数据可视化大屏，采用 **Spring Boot + MyBatis-Plus + ECharts** 全栈架构，对区域医疗电子病历与慢病随访数据进行多维度分析与实时展示。

> 本项目是 **"基于 Hadoop 与高可用架构的分布式日志分析与系统监控平台"** 课程作品的 **数据可视化子系统**，底层数据由 Hadoop HA + Hive 数仓 + Sqoop 数据迁移链路加工后导入 MySQL，再由本系统提供 REST API 与可视化大屏。

---

## 📸 项目截图

![首页大屏](screenshots/dashboard.png)

---

## 🧱 技术架构

```
┌─────────────────────────────────────────────────────┐
│                    前端可视化层                       │
│         ECharts 5.5 · 暗色主题 · 响应式布局           │
│         堆积面积图 / 柱状折线 / 玫瑰图 / 堆叠柱状      │
└──────────────────────┬──────────────────────────────┘
                       │ REST API (JSON)
┌──────────────────────┴──────────────────────────────┐
│                   后端服务层                          │
│       Spring Boot 2.7.18 · MyBatis-Plus 3.5.3.1     │
│       CORS 全局跨域 · 统一 Result 响应体              │
│       Java 8 · Maven · 端口 8090                     │
└──────────────────────┬──────────────────────────────┘
                       │ JDBC
┌──────────────────────┴──────────────────────────────┐
│                    数据存储层                         │
│       MySQL 5.7 (medical_dashboard)                  │
│       ← 数据来自 Hive 数仓 ← Sqoop 导入              │
│       ← Hadoop HA 集群 (ZooKeeper + NameNode)       │
└─────────────────────────────────────────────────────┘
```

| 层级 | 技术选型 |
|------|----------|
| 数据采集 | Hadoop HA · ZooKeeper · HDFS |
| 数据仓库 | Hive · HQL 聚合计算 |
| 数据迁移 | Sqoop (Hive → MySQL) |
| 数据存储 | MySQL 5.7 |
| 后端框架 | Spring Boot 2.7.18 |
| ORM | MyBatis-Plus 3.5.3.1 |
| 前端可视化 | ECharts 5.5.0 (CDN) |
| 构建工具 | Maven |
| 开发语言 | Java 8 / HTML5 / CSS3 / JavaScript |

---

## 📊 功能模块

| 序号 | 模块 | API 端点 | 图表类型 | 说明 |
|------|------|----------|----------|------|
| 1 | 疾病季节性趋势 | `/api/disease/trend` | 堆积面积图 | 各类疾病按月的就诊人次变化，支持同比分析 |
| 2 | 药品消耗预测 | `/api/drug/forecast` | 柱状图 + 折线图 | 实际消耗 vs 预测消耗对比，库存预警标记 |
| 3 | 科室工作量 | `/api/dept/workload` | 南丁格尔玫瑰图 | 各科室就诊人次排名与占比 |
| 4 | 区域疾病分布 | `/api/regional/distribution` | 堆叠横向柱状图 | 各区域不同疾病类别就诊分布 |
| 5 | 慢病随访监测 | `/api/chronic/monitor` | 双轴柱状图 | 随访率 & 控制达标率，含均值参考线 |

所有接口均支持 `year` / `month` 可选参数进行时间维度筛选。

---

## 🗂️ 项目结构

```
medical-dashboard/
├── pom.xml                                    # Maven 配置
├── frontend/
│   └── dashboard.html                         # 前端大屏（独立部署版）
├── src/main/java/com/medical/dashboard/
│   ├── MedicalDashboardApplication.java       # Spring Boot 启动类
│   ├── config/
│   │   ├── CorsConfig.java                    # 全局跨域配置
│   │   └── MyBatisPlusConfig.java             # MyBatis-Plus 分页插件
│   ├── controller/
│   │   ├── DashboardController.java           # REST API 控制器 (5 个接口)
│   │   └── Result.java                        # 统一响应体 {code, message, data}
│   ├── entity/
│   │   ├── DiseaseSeasonalTrend.java          # 疾病季节性趋势实体
│   │   ├── DrugConsumptionForecast.java       # 药品消耗预测实体
│   │   ├── DepartmentWorkload.java            # 科室工作量实体
│   │   ├── RegionalDiseaseDistribution.java   # 区域疾病分布实体
│   │   └── ChronicDiseaseMonitor.java         # 慢病随访监测实体
│   ├── mapper/                                # MyBatis-Plus Mapper 接口
│   │   ├── DiseaseSeasonalTrendMapper.java
│   │   ├── DrugConsumptionForecastMapper.java
│   │   ├── DepartmentWorkloadMapper.java
│   │   ├── RegionalDiseaseDistributionMapper.java
│   │   └── ChronicDiseaseMonitorMapper.java
│   └── service/
│       ├── DashboardService.java              # 业务接口
│       └── impl/
│           └── DashboardServiceImpl.java      # 业务实现
└── src/main/resources/
    ├── application.yml                        # 应用配置（数据库、端口等）
    └── static/
        └── index.html                         # 前端大屏（Spring Boot 托管版）
```

---

## 🚀 快速开始

### 环境要求

| 依赖 | 版本 |
|------|------|
| JDK | 1.8+ |
| Maven | 3.6+ |
| MySQL | 5.7+ |
| ECharts | 5.5.0 (CDN) |

### 1. 数据库准备

确保 MySQL 中已创建 `medical_dashboard` 数据库，并已通过 Sqoop 从 Hive 数仓导入以下 5 张业务表：

```sql
-- 数据库
CREATE DATABASE IF NOT EXISTS medical_dashboard DEFAULT CHARSET utf8mb4;

-- 5 张业务表（由 Sqoop 从 Hive 同步）
disease_seasonal_trend        -- 疾病季节性趋势
drug_consumption_forecast     -- 药品消耗预测
department_workload           -- 科室工作量
regional_disease_distribution -- 区域疾病分布
chronic_disease_monitor       -- 慢病随访监测
```

### 2. 修改配置

编辑 `src/main/resources/application.yml`，修改数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://<你的MySQL地址>:3306/medical_dashboard?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
    username: <你的用户名>
    password: <你的密码>
```

### 3. 启动后端

```bash
# 在项目根目录执行
mvn clean package -DskipTests
java -jar target/medical-dashboard-1.0.0.jar

# 或直接通过 Maven 启动
mvn spring-boot:run
```

启动成功后控制台输出：

```
========================================
  智慧医疗数据大屏后端服务已启动
  API 地址: http://localhost:8090
========================================
```

### 4. 访问大屏

打开浏览器访问：

```
http://localhost:8090/index.html
```

或直接打开 `frontend/dashboard.html`（需先修改其中的 `API_BASE` 常量指向后端地址）。

---

## 📡 API 文档

### 统一响应格式

```json
{
  "code": 200,
  "message": "success",
  "data": [...]
}
```

### 接口列表

所有接口路径前缀为 `/api`，均接受可选查询参数 `year` 和 `month`。

#### 1. 疾病季节性趋势

```
GET /api/disease/trend?year=2025&month=6
```

**响应字段：** `id`, `statYear`, `statMonth`, `season`, `diseaseCategory`, `visitCount`, `yoyGrowth`

#### 2. 药品消耗预测

```
GET /api/drug/forecast?year=2025&month=6
```

**响应字段：** `id`, `drugName`, `drugCategory`, `statYear`, `statMonth`, `actualQty`, `forecastQty`, `stockAlert`

#### 3. 科室工作量

```
GET /api/dept/workload?year=2025&month=6
```

**响应字段：** `id`, `statYear`, `statMonth`, `department`, `visitCount`, `avgWaitMin`, `rankInMonth`

#### 4. 区域疾病分布

```
GET /api/regional/distribution?year=2025&month=6
```

**响应字段：** `id`, `statYear`, `statMonth`, `region`, `diseaseCategory`, `visitCount`, `populationRatio`

#### 5. 慢病随访监测

```
GET /api/chronic/monitor?year=2025&month=6
```

**响应字段：** `id`, `statYear`, `statMonth`, `diseaseName`, `totalPatients`, `followupCount`, `followupRate`, `controlRate`

---

## 🎨 前端图表说明

| 图表位置 | ECharts 类型 | 数据模块 | 交互特性 |
|----------|-------------|----------|----------|
| 左上 | 堆积面积图 | 疾病季节性趋势 | Cross 准星提示，多维度下钻 |
| 中上 | 柱状图 + 折线交叉 | 药品消耗预测 | 渐变色柱 + 趋势线，Top 15 排序 |
| 右上 | 南丁格尔玫瑰图 | 科室工作量排名 | 面积玫瑰，按排名展示 |
| 左下 (2/3 宽) | 堆叠横向柱状图 | 区域疾病分布 | 区域 × 疾病矩阵对比 |
| 右下 (1/3 宽) | 双轴柱状图 | 慢病随访监测 | 双 Y 轴，均值参考线 |

**交互功能：** 年份/月份筛选器下拉联动，一键刷新按钮，响应式布局适配不同屏幕尺寸。

---

## 📝 相关项目

- **Hadoop HA 集群部署** — ZooKeeper + HDFS NameNode HA + YARN
- **Hive 数据仓库** — 医疗数据 HQL 聚合与维表建模
- **Sqoop 数据迁移** — Hive 分析结果定时导入 MySQL 业务库
- **系统监控平台** — 基于 Prometheus + Grafana 的集群监控告警

---

## 📄 开源协议

本项目仅用于学习与课程展示目的。

---

## 👨‍💻 作者

Hadoop 期末课程作品 — 基于 Hadoop 与高可用架构的分布式日志分析与系统监控平台
