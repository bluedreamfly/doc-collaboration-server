package com.hzh.doc.service.Document;


import com.hzh.doc.domain.Document;
import org.springframework.data.repository.Repository;

public interface DocumentRepository extends Repository<Document, Long> {

    Document save(Document doc);

//    Document

    Void delete(Long docId);

}
