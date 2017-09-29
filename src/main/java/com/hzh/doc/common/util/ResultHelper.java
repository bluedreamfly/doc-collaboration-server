package com.hzh.doc.common.util;

import com.hzh.doc.common.domain.Result;

public class ResultHelper {

    public static <T> Result<T> getSuccessResult(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("");
        result.setData(data);
        return result;
    }

}
