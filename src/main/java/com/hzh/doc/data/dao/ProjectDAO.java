package com.hzh.doc.data.dao;

import com.hzh.doc.data.mapper.ProjectMapper;
import com.hzh.doc.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {

    @Autowired
    private ProjectMapper projectMapper;

    public Boolean addProject(Project project) {
        return projectMapper.insert(project) != 0;
    }

    public Boolean delProject(String projectId) {
        return projectMapper.delete(projectId) != 0;
    }

    public Boolean updateProject(Project project) {
        return projectMapper.update(project) != 0;
    }

    public List<Project> findAll() {
        return projectMapper.findAll();
    }
}
