package com.hzh.doc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Integer memberNum;

    private String userIds;
}
