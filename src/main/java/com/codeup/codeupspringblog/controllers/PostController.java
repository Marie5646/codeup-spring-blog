package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class PostController {
    @GetMapping("/post")
    @ResponseBody
    public String post() {
        return " all post";
    }
    @GetMapping( "/post/{id}")
    @ResponseBody
    public String postById(@PathVariable int id){
        return  "<h1> create post for this "+ id +"</h1>";
    }
    @RequestMapping( path = "/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String createNewPost(){
        return  "<h1> lets create new post </h1>";
    }
    @GetMapping("/post/create")
    @ResponseBody
    public String formPost(){
        return  "<h1> form : create post </h1>";
    }

}
