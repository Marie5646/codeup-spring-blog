package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }






}
