package com.hzh.doc.service;

import com.hzh.doc.data.dao.DocInterfaceDAO;
import com.hzh.doc.domain.DocInterface;
import com.hzh.doc.util.GenerateId;
import com.sun.tools.javah.Gen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocInterfaceService {

    @Autowired
    private DocInterfaceDAO docInterfaceDAO;

    public DocInterface addDocInterface(DocInterface docInterface) {
        if (null == docInterface.getId()) {
            docInterface.setId(GenerateId.genUniqueKey());
        }
        Boolean result = docInterfaceDAO.addDocInterface(docInterface);
        if (result) {
            return docInterface;
        }
        return null;
    }

    public Boolean updateDocInterface(DocInterface docInterface) {
        return docInterfaceDAO.updateDocInterface(docInterface);
    }

    public Boolean delDocInterface(String interfaceId) {
        return docInterfaceDAO.delDocInterface(interfaceId);
    }

    public List<DocInterface> findAllByDocId(String docId) {
        return docInterfaceDAO.findAllByDocId(docId);
    }
}
