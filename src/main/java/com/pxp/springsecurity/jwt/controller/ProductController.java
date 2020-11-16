package com.pxp.springsecurity.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class ProductController {

    @RequestMapping(value = "info",method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello PXP!";
    }
}
