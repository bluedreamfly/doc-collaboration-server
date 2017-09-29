package com.hzh.doc.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 文档模型
 */
@Data
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    //文档ID
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    //文档标题
//    @NotNull(message = "文档标题不能为空")
    private String title;

    //文档描述
    private String description;


//    @NotNull(message = "创建者不能为空")
    private String createUser;

    //文档更新者
    private String updateUser;

    //新增时间
    private Date addTime;

    //更新时间
//    @NotNull
    private Date updateTime;

    private String dirId;

    private String projectId;


}
