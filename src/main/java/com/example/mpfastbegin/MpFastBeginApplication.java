package com.example.mpfastbegin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.example.mpfastbegin.mapper")
@ComponentScan(basePackages = "com.example.mpfastbegin.config")
@SpringBootApplication
@EnableTransactionManagement

public class MpFastBeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpFastBeginApplication.class, args);
    }
}
