package com.hzh.doc.controller;


import com.hzh.doc.common.domain.Result;
import com.hzh.doc.common.util.ResultHelper;
import com.hzh.doc.domain.Project;
import com.hzh.doc.domain.TreeNode;
import com.hzh.doc.exception.ResponseException;
import com.hzh.doc.service.ProjectService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST)
    public Result<?> addProject(Project project) {
        Project result = projectService.addProject(project);
        if (result != null) {
            return ResultHelper.getSuccessResult(result);
        }
        throw new ResponseException("10003", "添加失败");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result<List<Project>> getProjects() {
        return ResultHelper.getSuccessResult(projectService.getProjects());
    }


    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public Result<TreeNode> getProjectMenu(@RequestParam String projectId) {

        return ResultHelper.getSuccessResult(projectService.getMenu(projectId));
    }

}
