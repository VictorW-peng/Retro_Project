# Retro_Project

个人技术实践项目集合，当前包含一个基于 Spring Boot 的多模块后端工程 `suture-server`。

## 模块说明

| 路径 | 说明 |
| --- | --- |
| `suture/suture-server/suture-server-common` | 通用能力：统一响应结构、错误码、业务异常、日期/Excel 工具 |
| `suture/suture-server/suture-server-core` | 核心业务抽象：通用 CRUD 接口、算法、核心异常 |
| `suture/suture-server/suture-server-solution` | 应用启动模块：Web、MyBatis、配置、接口、日志、测试 |

## 快速开始

```bash
cd suture/suture-server

# 构建并运行全部测试（测试使用 H2 内存库，无需本地 MySQL）
mvn clean install

# 本地启动（默认 dev 环境，连接 localhost:3306/suture）
mvn -pl suture-server-solution spring-boot:run

# 或打包后运行
java -jar suture-server-solution/target/suture-server.jar
```

启动后：

- 接口地址：`http://localhost:8088`
- 接口文档：`http://localhost:8088/swagger-ui.html`
- 健康检查：`http://localhost:8088/actuator/health`

详细配置、环境变量与接口约定见 [suture/suture-server/README.md](suture/suture-server/README.md)。

## 技术栈

- JDK 11
- Spring Boot 2.7.18
- MyBatis 2.3.2 + MySQL 8
- springdoc-openapi 1.7.0（OpenAPI 3）
- Log4j2
- JUnit 5 + MockMvc + H2

## 说明

仓库中的示例业务代码来自个人学习实践，重构后的基础框架作为后续业务模块的统一底座。
