package com.hzh.doc.service;

import com.hzh.doc.data.dao.DocInterfaceDAO;
import com.hzh.doc.data.dao.DocumentDAO;
import com.hzh.doc.domain.DocInterface;
import com.hzh.doc.domain.Document;
import com.hzh.doc.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service

public class DocumentService  {

    @Autowired
    private DocumentDAO documentDAO;

    @Autowired
    private DocInterfaceDAO docInterfaceDAO;



    public Document saveDocument(Document doc) {
         if (null == doc.getId()) {
             doc.setId(GenerateId.genUniqueKey());
         }
         doc.setAddTime(new Date());
         Boolean result = documentDAO.addDocument(doc);
         if (result) {
            return doc;
         }
         return null;
    }

    public Boolean delDocument(Long docId) {
        return documentDAO.delDocument(docId);
    }


    public List<Document> getDocuments(String projectId) {
        return documentDAO.findAllByProjectId(projectId);
    }

    public Boolean updateDocument(Document document) {
        return documentDAO.updateDocument(document);
    }

    public Document getDocumentDetail(String docId) {

        List<DocInterface> docInterfaces = docInterfaceDAO.findAllByDocId(docId);
        Document document = documentDAO.findDocumentById(docId);

        document.setInterfaces(docInterfaces);
//        Map<String, Object> resultMap = new HashMap<>();
//
//        resultMap.put("id", document.getId());
//        resultMap.put("title", document.getTitle());
//        resultMap.put("description", document.getDescription());
//        resultMap.
        return document;
    }


//    public Result<?> getDocuemnt(Long )
//    @Override
//    public void delDocument(Long docId) {
//        documentRepository.delete(docId);
//    }


}
