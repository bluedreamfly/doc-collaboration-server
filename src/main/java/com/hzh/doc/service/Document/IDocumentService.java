package com.hzh.doc.service.Document;

import com.hzh.doc.domain.Document;

public interface IDocumentService {

    public Document saveDocument(Document doc);

    public void delDocument(Long docId);
}
