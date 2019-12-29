package com.york.common;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -5596727894144681269L;

    protected final String    code;

    public BusinessException() {
        this.code = null;
    }

    public BusinessException(final String message) {
        super(message);
        this.code = null;
    }

    public BusinessException(final Throwable cause) {
        super(cause);
        this.code = null;
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
        this.code = null;
    }

    public BusinessException(final String code, final String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(final String code, final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}