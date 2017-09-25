package com.hzh.doc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文档模型
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    //文档ID
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //文档标题
    @Column(name = "title")
    @NotNull(message = "文档标题不能为空")
    private String title;

    //文档描述
    @Column(name = "description")
    private String description;

    @Column(name = "create_user")
    @NotNull(message = "创建者不能为空")
    private String createUser;

    //文档更新者
    @Column(name = "update_user")
    private String updateUser;

    //新增时间
    @Column(name = "add_time")
    private Date addTime;

    //更新时间
    @Column(name = "update_time")
//    @NotNull
    private Date updateTime;

    //接口列表
    @OneToMany(mappedBy = "id")
    @Column(name = "doc_interfaces")
    private List<DocInterface> docInterfaces;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<DocInterface> getDocInterfaces() {
        return docInterfaces;
    }

    public void setDocInterfaces(List<DocInterface> docInterfaces) {
        this.docInterfaces = docInterfaces;
    }
}
