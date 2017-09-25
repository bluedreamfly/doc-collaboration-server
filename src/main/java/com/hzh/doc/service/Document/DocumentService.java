package com.hzh.doc.service.Document;

import com.hzh.doc.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class DocumentService implements IDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document saveDocument(Document doc) {
         return documentRepository.save(doc);
    }

    @Override
    public void delDocument(Long docId) {
        documentRepository.delete(docId);
    }


}
