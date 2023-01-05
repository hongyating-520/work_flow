package com.example.oldguy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.**")
public class FlowableModelerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableModelerDemoApplication.class, args);
    }

}
