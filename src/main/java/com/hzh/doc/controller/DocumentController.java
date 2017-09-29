package com.hzh.doc.controller;

import com.hzh.doc.common.domain.Result;
import com.hzh.doc.common.util.ResultHelper;
import com.hzh.doc.exception.ResponseException;
import com.hzh.doc.domain.Document;
//import com.hzh.doc.service.DocInterface.IDocInterfaceService;
import com.hzh.doc.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;


//    private IDocInterfaceService docInterfaceService;

    @RequestMapping(method = RequestMethod.POST)
    public Result<Document> addDocument(@Valid Document doc, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            List<ObjectError> errors = bindingResult.getAllErrors();
            throw new ResponseException("10001", errors.get(0).getDefaultMessage());
        }
        Document document = documentService.saveDocument(doc);

        return ResultHelper.getSuccessResult(document);

    }

    @RequestMapping(value = "/{docId}", method = RequestMethod.DELETE)
    public Boolean delDocument(@PathVariable Long docId) throws Exception {

        Boolean result = documentService.delDocument(docId);
        if (!result) {
            throw new ResponseException("10001", "文档不存在");
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result<?> updateDocument(Document document) {
        Boolean result = documentService.updateDocument(document);
        if (!result) {
            throw new ResponseException("10001", "文档不存在");
        }
        return ResultHelper.getSuccessResult(result);
    }



//
//    @RequestMapping(value = "/{docId}/interfaces", method = RequestMethod.GET)
//    public Page<DocInterface> getDocumentInterfaces(@PathVariable Long docId) {
//        return docInterfaceService.findBookNoCriteria(1, 2);
//    }



}
