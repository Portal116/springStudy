package com.spring.study.main.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    Logger logger = LogManager.getLogger(MainController.class);

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping(value = "/sign-in")
    public String getSignIn() {
        logger.info("sign-in");
        return "sign-in";
    }
}
