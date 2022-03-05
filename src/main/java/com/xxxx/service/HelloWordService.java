package com.xxxx.service;

import com.xxxx.config.MyControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWordService {
    private Logger logger = LoggerFactory.getLogger(HelloWordService.class);
    public void log() {
        logger.info("=========HelloWordService HelloWord.log start=======");
        logger.info("=========HelloWordService HelloWord.log end=======");
    }
}
