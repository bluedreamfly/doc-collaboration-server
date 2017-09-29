package com.hzh.doc.exception;

public class ResponseException extends RuntimeException {

    private String code;

    private String msg;

    public ResponseException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
