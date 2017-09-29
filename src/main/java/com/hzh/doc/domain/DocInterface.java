//package com.hzh.doc.domain;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * 文档接口模型
// */
//
//@Entity
//@Table(name = "doc_interface")
//public class DocInterface implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    //接口id
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    //接口标题
//    private String title;
//
//    //接口类型
//    //1: 真正的接口 2: 一般的文档描述
//    private Integer type;
//
//    //接口请求路径
//    private String path;
//
//    //接口请求参数
//    private String reqParams;
//
//    //文档的id
//    private Long docId;
//
//    //接口响应数据
//    private String res;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Integer getType() {
//        return type;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    public String getReqParams() {
//        return reqParams;
//    }
//
//    public void setReqParams(String reqParams) {
//        this.reqParams = reqParams;
//    }
//
//    public String getRes() {
//        return res;
//    }
//
//    public void setRes(String res) {
//        this.res = res;
//    }
//
//    public Long getDocId() {
//        return docId;
//    }
//
//    public void setDocId(Long docId) {
//        this.docId = docId;
//    }
//}
