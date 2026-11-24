package com.example.common.api;

/**
 * 统一错误码。
 *
 * <p>code 为业务码，httpStatus 用于 REST 层映射 HTTP 状态。</p>
 */
public enum ErrorCode {

    SUCCESS(0, "成功", 200),

    BAD_REQUEST(40000, "请求参数不合法", 400),
    UNAUTHORIZED(40100, "未认证或登录已过期", 401),
    FORBIDDEN(40300, "没有访问权限", 403),
    NOT_FOUND(40400, "请求的资源不存在", 404),
    METHOD_NOT_ALLOWED(40500, "请求方法不支持", 405),
    CONFLICT(40900, "资源状态冲突", 409),
    INTERNAL_ERROR(50000, "系统内部错误", 500),
    SERVICE_UNAVAILABLE(50300, "服务暂不可用", 503),

    BUSINESS_ERROR(60000, "业务处理失败", 400),
    LOGIN_FAILED(60001, "用户名或密码错误", 400),
    DATA_NOT_FOUND(60002, "数据不存在", 404),
    DUPLICATE_DATA(60003, "数据已存在", 409),
    DATA_ACCESS_ERROR(60004, "数据访问失败", 500);

    private final int code;
    private final String message;
    private final int httpStatus;

    ErrorCode(int code, String message, int httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public static ErrorCode of(int code) {
        for (ErrorCode value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return INTERNAL_ERROR;
    }
}
