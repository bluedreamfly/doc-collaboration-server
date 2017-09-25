package com.hzh.doc.controller;


import com.hzh.doc.domain.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class product {

    @RequestMapping(value = "/")
    public String test() throws Exception {
//        throw new Exception("Sam 错误");
        return "hello world 111122222224444";
    }

    @RequestMapping(value = "/products")
    public List<Product> getProductList() {
        List<Product> products = new ArrayList<Product>();
        for(int i = 0; i < 20; i++) {
            Product p = new Product();
            p.setId(i + "");
            p.setName("hzh" + i);
            p.setPrice((double)i);

            products.add(p);
        }
        return products;
    }

}
