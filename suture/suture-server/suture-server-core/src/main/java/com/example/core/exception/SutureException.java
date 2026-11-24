package com.example.core.exception;

import com.example.common.api.ErrorCode;
import com.example.common.exception.BusinessException;

/**
 * 核心模块业务异常，继承统一业务异常，便于全局异常处理器统一处理。
 *
 * @author William.Peng
 */
public class SutureException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public SutureException(String message) {
        super(message);
    }

    public SutureException(String message, Throwable cause) {
        super(ErrorCode.BUSINESS_ERROR, message, cause);
    }
}
