package com.hzh.doc.service;

import com.hzh.doc.common.domain.Result;
import com.hzh.doc.common.util.ResultHelper;
import com.hzh.doc.data.dao.DirectoryDAO;
import com.hzh.doc.domain.Directory;
import com.hzh.doc.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DirectoryService {

    @Autowired
    private DirectoryDAO directoryDAO;

    public Boolean addDirectory(Directory directory) {
        if (null == directory.getId()) {
            directory.setId(GenerateId.genUniqueKey());
        }
        directory.setAddTime(new Date());
        return directoryDAO.addDirectory(directory);
    }

    public Boolean delDirectory(String dirId) {
        return directoryDAO.delDirectory(dirId);
    }

    public Directory findDirectoryById(String dirId) {

        return directoryDAO.findDirectoryById(dirId);
    }

    public Boolean updateDirectory(Directory directory) {
        return directoryDAO.updateDirectory(directory);
    }

    public List<Directory> getDirectorys(String projectId) {
        return directoryDAO.findAllByProjectId(projectId);
    }

}
