package com.xxxx.controller;

import com.xxxx.config.MyControllerAdvice;
import com.xxxx.service.HelloWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWord {

    private Logger logger = LoggerFactory.getLogger(HelloWord.class);
    @Autowired
    HelloWordService helloWordService;

    @GetMapping("/log")
    public String log(){
        logger.info("=========HelloWord.log start=======");
        helloWordService.log();
        logger.info("=========HelloWord.log end=======");
        return  "ok";
    }

    @GetMapping("/exception")
    public String exception(){
        logger.info("=========HelloWord.exception start=======");
        int i = 1/0;
        logger.info("=========HelloWord.exception end=======");
        return  "ok";
    }
}
