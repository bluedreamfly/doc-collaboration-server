package com.hzh.doc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@MapperScan("com.hzh.doc.data.mapper")
public class DocApplication {
	public static void main(String[] args) {
		SpringApplication.run(DocApplication.class, args);
	}
}
