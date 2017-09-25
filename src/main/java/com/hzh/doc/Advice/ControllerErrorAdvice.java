package com.hzh.doc.Advice;

import com.hzh.doc.Exception.ResponseException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerErrorAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("test .........");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler(value = ResponseException.class)
    public Map errorHandler(ResponseException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        map.put("data", null);
        return map;
    }

//    @ResponseBody
//    @ExceptionHandler(value = BindException.class)
//    public Map errorHandler(BindException ex) {
//        Map map = new HashMap();
//        map.put("code", "10002");
//        map.put("msg", "参数不正确");
//        map.put("data", null);
//        return map;
//    }

    @ResponseBody
    public void test() {
//        Map map = new HashMap();
//        map.put("code", ex.getCode());
//        map.put("msg", ex.getMsg());
//        map.put("data", null);
//        return map;
        System.out.println("test .........");
    }

}
