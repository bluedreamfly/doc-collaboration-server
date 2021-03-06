package com.hzh.doc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String email;

    private String password;

    private List<String> projectIds;

}
