package com.hzh.doc.data.dao;

import com.hzh.doc.data.mapper.DocumentMapper;
import com.hzh.doc.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentDAO {

    @Autowired
    private DocumentMapper documentMapper;

    public Boolean addDocument(Document document) {
        return documentMapper.insert(document) != 0;
    }

    public Boolean delDocument(Long docId) {
        return documentMapper.delete(docId) != 0;
    }

    public Document findDocumentById(String docId) {
        return documentMapper.select(docId);
    }

    public List<Document> findAllByProjectId(String projectId) {
        return documentMapper.findAllByProjectId(projectId);
    }

    public Boolean updateDocument(Document document) {
        return documentMapper.update(document) != 0;
    }

//    public Document
}
