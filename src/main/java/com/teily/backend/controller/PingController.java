package com.teily.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController
{
    @GetMapping("/teilys/ping")
    public String pingOk(){
        return "Server is Up!";
    }
}
