package com.hzh.doc.controller;

import com.hzh.doc.Exception.ResponseException;
import com.hzh.doc.domain.Document;
import com.hzh.doc.service.Document.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
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
    private IDocumentService documentService;

    @RequestMapping(method = RequestMethod.POST)
    public Document addDocument(@Valid Document doc, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            List<ObjectError> errors = bindingResult.getAllErrors();
            throw new ResponseException("10001", errors.get(0).getDefaultMessage());
        }

        doc.setAddTime(new Date());
        return documentService.saveDocument(doc);
    }

    @RequestMapping(value = "/{docId}", method = RequestMethod.DELETE)
    public void delDocument(@PathVariable Long docId) throws Exception {
        try {
            documentService.delDocument(docId);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseException("10001", "文档不存在");
        }

    }



}
