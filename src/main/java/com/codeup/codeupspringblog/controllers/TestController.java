package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    /// Get Request
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "Hello Kotlin!";
    }
    @GetMapping("/parks/{park}")
    @ResponseBody
    public String parks(@PathVariable String park ,@PathVariable String message){
        return "<h1>Welcome to " + park + "!</h1><p>" + message + "</p>";
    }
}
