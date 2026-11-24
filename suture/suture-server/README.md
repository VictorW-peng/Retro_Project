# suture-server 后端基础框架

多模块 Maven 工程，统一管理依赖版本、运行配置、响应结构、异常处理与日志。

## 1. 模块与依赖关系

```
suture-server (parent, 统一依赖与插件版本)
├── suture-server-common   通用工具、统一响应 Result、错误码、业务异常
├── suture-server-core     核心业务抽象（CUDRService）、算法、核心异常
└── suture-server-solution Spring Boot 应用：Web / MyBatis / 配置 / 接口 / 测试
```

- 所有模块继承同一父 POM，统一 `java.version=11`、编码和依赖版本。
- `solution` 依赖 `core`，`core` 依赖 `common`。

## 2. 环境要求

| 工具 | 版本 |
| --- | --- |
| JDK | 11 及以上 |
| Maven | 3.8+ |
| MySQL | 8.0（仅本地/生产运行需要，测试用 H2） |

## 3. 构建与测试

```bash
cd suture/suture-server

mvn clean install         # 全量编译 + 单元/集成测试，并安装到本地仓库
mvn -DskipTests package   # 只打包
```

测试通过 `@ActiveProfiles("test")` 使用 H2 内存库，并自动执行
`suture-server-solution/src/test/resources/db/schema-h2.sql` 与 `data-h2.sql`，
不再依赖本机 MySQL。

## 4. 运行

```bash
# 方式一：直接运行（使用 dev 配置）
mvn -pl suture-server-solution spring-boot:run

# 方式二：打包后运行
mvn -DskipTests package
java -jar suture-server-solution/target/suture-server.jar --spring.profiles.active=dev
```

首次初始化数据库可执行 `docs/sql/schema.sql`。

默认端口 `8088`，可通过 `SERVER_PORT` 覆盖。

## 5. 配置说明

配置采用 Spring Boot 多环境方案：

| 文件 | 用途 |
| --- | --- |
| `application.yml` | 公共配置：端口、编码、Jackson、MyBatis、springdoc、Actuator、CORS、日志 |
| `application-dev.yml` | 本地开发：本机 MySQL、HikariCP 连接池、DEBUG 日志 |
| `application-prod.yml` | 生产：数据库信息全部来自环境变量，默认关闭 Swagger |
| `src/test/resources/application-test.yml` | 测试：H2 内存库、关闭 Swagger |

常用环境变量：

| 变量 | 默认值（dev） | 说明 |
| --- | --- | --- |
| `SERVER_PORT` | `8088` | 服务端口 |
| `SPRING_PROFILES_ACTIVE` | `dev` | 激活环境 |
| `DB_HOST` / `DB_PORT` / `DB_NAME` | `localhost` / `3306` / `suture` | 数据库地址 |
| `DB_USERNAME` / `DB_PASSWORD` | `root` / `123456` | 数据库账号（prod 无默认值） |
| `DB_POOL_MAX_SIZE` / `DB_POOL_MIN_IDLE` | `10` / `2` | HikariCP 连接池 |
| `SWAGGER_ENABLED` | `true`（prod 为 `false`） | 是否开放接口文档 |
| `CORS_ALLOWED_ORIGIN_PATTERN` | `*` | 允许的跨域来源模式 |
| `TRACE_HEADER_NAME` | `X-Trace-Id` | 链路 ID 请求/响应头 |
| `LOG_PATH` / `LOG_LEVEL` / `APP_NAME` | `./logs` / `INFO` / `suture` | 日志路径、级别、文件名 |

> 生产环境建议通过 `SPRING_PROFILES_ACTIVE=prod` 启动，并显式提供数据库相关环境变量。

## 6. 统一响应与异常

所有业务接口返回统一结构：

```json
{
  "success": true,
  "code": 0,
  "message": "成功",
  "data": {},
  "traceId": "b1c2...",
  "timestamp": "2026-11-24 14:30:00"
}
```

- 业务码见 `com.example.common.api.ErrorCode`。
- 全局异常处理 `GlobalExceptionHandler` 将参数校验、业务异常、数据访问异常、未知异常统一转换，
  并映射合适的 HTTP 状态码。
- 每个请求由 `TraceIdFilter` 生成或透传 `X-Trace-Id`，写入 MDC 与日志、响应头，
  前端报障时可直接提供该 ID。

常见错误码：

| code | 含义 |
| --- | --- |
| `0` | 成功 |
| `40000` | 请求参数不合法 |
| `60001` | 用户名或密码错误 |
| `60002` | 数据不存在 |
| `60004` | 数据访问失败 |
| `50000` | 系统内部错误 |

## 7. 接口一览

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| GET | `/user/allUser` | 查询所有用户（密码字段不返回） |
| GET | `/user/UserByName?userName=` | 按用户名查询，不存在返回 404 + `60002` |
| POST | `/user/Login` | 表单参数 `userName`、`passWord` 登录校验 |
| GET | `/test` | 示例接口 |
| GET | `/swagger-ui.html` | 接口文档（dev 默认开启） |
| GET | `/actuator/health` | 健康检查 |
| GET | `/actuator/info` | 应用信息 |

## 8. 目录约定

```
src/main/java/com/example/solution
├── config        配置类（CORS、OpenAPI）
├── controller    接口层
├── dao           MyBatis Mapper 接口
├── entity        实体
├── service       业务接口
├── support/web   全局异常、traceId 等 Web 支撑
└── service/impl  业务实现

src/main/resources
├── application*.yml  多环境配置
├── log4j2.xml        日志配置
└── mapper/*.xml      MyBatis SQL 映射
```

## 9. 后续计划

- 密码由明文比对升级为 BCrypt/Argon2 加盐哈希，并补齐登录态与权限模型。
- 列表接口引入分页与查询条件对象，避免全表返回。
- 补充统一请求日志与慢 SQL 监控。
- 生产环境接入配置中心与密钥管理，替换环境变量中的数据库口令。
