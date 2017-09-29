package com.hzh.doc.controller;

import com.hzh.doc.common.domain.Result;
import com.hzh.doc.common.util.ResultHelper;
import com.hzh.doc.domain.Directory;
import com.hzh.doc.domain.Document;
import com.hzh.doc.exception.ResponseException;
import com.hzh.doc.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/directory")
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    @RequestMapping(method = RequestMethod.POST)
    public Result<?> addDirectory(Directory directory) {
        Boolean result = directoryService.addDirectory(directory);
        return ResultHelper.getSuccessResult(result);
    }

    @RequestMapping(value="/{dirId}", method = RequestMethod.DELETE)
    public Result<?> delDirectory(@PathVariable String dirId){
        Boolean result = directoryService.delDirectory(dirId);
        return ResultHelper.getSuccessResult(result);
    }

    @RequestMapping(value = "/{dirId}", method = RequestMethod.GET)
    public Result<?> getDirectory(@PathVariable String dirId) {
        return ResultHelper.getSuccessResult(directoryService.findDirectoryById(dirId));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result<?> updateDirectory(Directory directory) {
        Boolean result = directoryService.updateDirectory(directory);
        if (!result) {
            throw new ResponseException("10001", "文档不存在");
        }
        return ResultHelper.getSuccessResult(result);
    }
}
