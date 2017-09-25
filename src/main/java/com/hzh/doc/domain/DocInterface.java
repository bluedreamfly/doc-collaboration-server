package com.hzh.doc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文档接口模型
 */

@Entity
@Table(name = "doc_interface")
public class DocInterface {

    //接口id
    @Id
    private String id;

    //接口标题
    private String title;

    //接口类型
    private String type;

    //接口请求路径
    private String path;

    //接口请求参数
    private String req_params;

    //接口响应数据
    private String res;

}
