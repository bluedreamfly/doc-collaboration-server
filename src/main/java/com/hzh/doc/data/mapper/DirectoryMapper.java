package com.hzh.doc.data.mapper;

import com.hzh.doc.domain.Directory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectoryMapper {

    int insert(Directory directory);

    int delete(String dirId);

    int update(Directory directory);

    Directory select(String dirId);

    List<Directory> findAllByProjectId(String projectId);

}
