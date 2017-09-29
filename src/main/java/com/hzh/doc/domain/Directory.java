package com.hzh.doc.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Directory implements Serializable{


    private String id;

    //目录名称
    private String name;

    //所属目录id
    private String dirId;

    //添加时间
    private Date addTime;

    //更新时间
    private Date updateTime;

    //所属项目Id
    private String projectId;

}
