package com.hzh.doc.data.dao;

import com.hzh.doc.data.mapper.DocInterfaceMapper;
import com.hzh.doc.domain.DocInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocInterfaceDAO {
    @Autowired
    private DocInterfaceMapper docInterfaceMapper;

    public Boolean addDocInterface(DocInterface docInterface) {
        return docInterfaceMapper.insert(docInterface) != 0;
    }

    public Boolean updateDocInterface(DocInterface docInterface) {
        return docInterfaceMapper.update(docInterface) != 0;
    }

    public Boolean delDocInterface(String interfaceId) {
        return docInterfaceMapper.delete(interfaceId) != 0;
    }

    public List<DocInterface> findAllByDocId(String docId) {
        return docInterfaceMapper.findAllByDocId(docId);
    }


}
