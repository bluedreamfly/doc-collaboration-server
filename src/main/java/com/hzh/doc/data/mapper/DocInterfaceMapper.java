package com.hzh.doc.data.mapper;

import com.hzh.doc.domain.DocInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocInterfaceMapper {

    int insert(DocInterface docInterface);

    int delete(String interfaceId);

    int update(DocInterface docInterface);

    List<DocInterface> findAllByDocId(String docId);
}
