//package com.hzh.doc.service.DocInterface;
//
//import com.hzh.doc.domain.DocInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DocInterfaceService implements IDocInterfaceService{
//
//    @Autowired
//    private DocInterfaceRepository docInterfaceRepository;
//
//    @Override
//    public DocInterface saveInterface(DocInterface docInterface) {
//        return docInterfaceRepository.save(docInterface);
//    }
//
//    @Override
//    public Page<DocInterface> findBookNoCriteria(Integer page, Integer pageSize) {
//        Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
//        return docInterfaceRepository.findAll(pageable);
//    }
//
//
//
//
//}
