package com.example.springtracerapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtracerapp.service.RootService;

import javax.annotation.Resource;

@RestController
public class RootController {
    @Resource
    private RootService rootService;

    @RequestMapping("/one")
    public String one(){
        return "Response from One";
    }
    @GetMapping("/resttemplate")
    public ResponseEntity<String> two(){
        return new ResponseEntity<String>(rootService.getUsingRestTemplate(), HttpStatus.OK);
    }
}
