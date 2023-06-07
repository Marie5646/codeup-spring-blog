package com.codeup.codeupspringblog.controllers;

//import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping( "/add/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable int num1 , @PathVariable int num2){
        return  "<h1>" + (num1 + num2) + "</h1>";
    }
    @GetMapping( "/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1 , @PathVariable int num2){
        return  "<h1>" + (num1 - num2) + "</h1>";
    }
    @GetMapping( "/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1 , @PathVariable int num2){
        return  "<h1>" + (num1 * num2) + "</h1>";
    }
    @GetMapping( "/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1 , @PathVariable int num2){
        return  "<h1>" + (num1/ num2) + "</h1>";
    }



}
