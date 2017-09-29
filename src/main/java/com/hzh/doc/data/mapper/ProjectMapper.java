package com.hzh.doc.data.mapper;

import com.hzh.doc.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {

    int insert(Project project);

    int delete(String projectId);

    int update(Project project);

    List<Project> findAll();
}
