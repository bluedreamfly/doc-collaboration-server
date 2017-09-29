package com.hzh.doc.data.mapper;

import com.hzh.doc.domain.Document;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DocumentMapper {

    int insert(Document document);

    int delete(Long docId);

    Document select(String docId);

    List<Document> findAllByProjectId(String projectId);

    int update(Document document);

}
