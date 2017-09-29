package com.hzh.doc.domain;

import lombok.Data;

import java.util.List;

@Data
public class TreeNode {

    private String id;

    private Boolean isDoc;

    private String name;

    private List<TreeNode> children;
}
