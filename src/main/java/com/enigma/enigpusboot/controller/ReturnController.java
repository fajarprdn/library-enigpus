package com.enigma.enigpusboot.controller;

import com.enigma.enigpusboot.constant.ApiUrlConstant;
import com.enigma.enigpusboot.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(ApiUrlConstant.RETURN)
public class ReturnController {

    @Autowired
    ReturnService returnService;

    @PostMapping
    public void bookReturn(@RequestParam String borrowId){
        returnService.bookReturn(borrowId);
    }

}
