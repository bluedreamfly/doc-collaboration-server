package com.hzh.doc.common.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable{

    private Integer code;

    private String msg;


    private T data;


    public void getSuccessResult(T data) {
        this.data = data;
        this.code = 0;
    }

}
