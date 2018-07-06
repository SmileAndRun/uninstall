package com.bdcom.hws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bdcom.hws.mapper")//添加对mapper层的扫描 
public class HwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwsApplication.class, args);
	}
}
