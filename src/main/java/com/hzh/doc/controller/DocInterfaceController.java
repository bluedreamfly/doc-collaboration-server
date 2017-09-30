package com.hzh.doc.controller;


import com.hzh.doc.common.domain.Result;
import com.hzh.doc.common.util.ResultHelper;
import com.hzh.doc.domain.DocInterface;
import com.hzh.doc.exception.ResponseException;
import com.hzh.doc.service.DocInterfaceService;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/interface")
public class DocInterfaceController {

    @Autowired
    private DocInterfaceService docInterfaceService;

    @RequestMapping(method = RequestMethod.POST)
    public Result<?> addInterface(DocInterface docInterface) {
        return ResultHelper.getSuccessResult(docInterfaceService.addDocInterface(docInterface));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result<List<DocInterface>> getInterface(@RequestParam String docId) {
        return ResultHelper.getSuccessResult(docInterfaceService.findAllByDocId(docId));
    }

    @RequestMapping(value = "/{interfaceId}", method = RequestMethod.DELETE)
    public Result<?> delInterface(@PathVariable String interfaceId) {
        Boolean result = docInterfaceService.delDocInterface(interfaceId);
        if (!result) {
            throw new ResponseException("10001", "文档不存在");
        }
        return ResultHelper.getSuccessResult(result);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result<?> updateInterface(DocInterface docInterface) {
        Boolean result = docInterfaceService.updateDocInterface(docInterface);
        if (!result) {
            throw new ResponseException("10001", "文档不存在");
        }
        return ResultHelper.getSuccessResult(result);
    }

}
