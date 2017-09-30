package com.hzh.doc.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 文档接口模型
 */


@Data
public class DocInterface implements Serializable {

    private static final long serialVersionUID = 1L;
    //接口id
    private String id;

    //接口标题
    private String title;

    //接口类型
    //1: 真正的接口 2: 一般的文档描述
    private Integer type;

    //接口请求路径
    private String path;

    //接口请求参数
    private String reqParams;

    //文档的id
    private String docId;

    //接口响应数据
    private String res;

    //接口请求方法
    private String method;
}
