package com.hzh.doc.data.dao;


import com.hzh.doc.data.mapper.DirectoryMapper;
import com.hzh.doc.domain.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectoryDAO {

    @Autowired
    private DirectoryMapper directoryMapper;

    public Boolean addDirectory(Directory directory) {
        return directoryMapper.insert(directory) != 0;
    }

    public Boolean delDirectory(String dirId) {
        return directoryMapper.delete(dirId) != 0;
    }

    public Boolean updateDirectory(Directory directory) {
        return directoryMapper.update(directory) != 0;
    }

    public Directory findDirectoryById(String dirId) {
        return directoryMapper.select(dirId);
    }

    public List<Directory> findAllByProjectId(String projectId) {
        return directoryMapper.findAllByProjectId(projectId);
    }


}
