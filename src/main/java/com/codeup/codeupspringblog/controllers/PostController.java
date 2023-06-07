package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/post")
    @ResponseBody
    public ArrayList<Post> post() {
        ArrayList <Post> posts = new ArrayList<>();
        Post myPost = new Post("hey","Hello World");
        Post thePost = new Post("bye","bye World");
        posts.add(myPost);
        posts.add(thePost);
        return posts;
    }
    @GetMapping( "/post/{id}")
    @ResponseBody
    public String postById(@PathVariable long id){
        Post myPost = new Post(1L,"hey","Hello World");
        return  "<h1> create post for this "+ myPost +"</h1>";
    }
    @GetMapping("/post/create")
    @ResponseBody
    public String formPost(){
        return "post/create";
    }



    @PostMapping("/post/complete")
    @ResponseBody
    public String postComplete(@RequestParam (name = "title"String title, @RequestParam (name = "body"String body),Model model){
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";

    }
}
