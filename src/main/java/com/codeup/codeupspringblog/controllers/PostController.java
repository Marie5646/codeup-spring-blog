package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("posts", postDao.findAll());

//        getting useremail using finddbyid method
        String userEmail = userDao.findById(1L).get().getEmail();
        model.addAttribute("email",userEmail);
//        ArrayList <Post> posts = new ArrayList<>();
//        Post myPost = new Post("hey","Hello World");
//        Post thePost = new Post("bye","bye World");
//        posts.add(myPost);
//        posts.add(thePost);
        return "post/index";
    }

    @GetMapping("/post/{id}")
    @ResponseBody
    public String postById(@PathVariable long id) {
//        Post myPost = new Post(1L,"hey","Hello World");
        return "<h1> create post for this" + "</h1>";
    }

    @GetMapping("/post/create")
    public String formPost() {
        return "post/create";
    }


    @PostMapping("/post/create")
    public String postComplete(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
//        if (userDao.findById(userId).isPresent()) {

//        using user instance to find user by id
            User user1 = userDao.findById(1L).get();

//        creating new post using userinput
            Post newPost = new Post(title, body);
//        setting user found using find by id method to newpost created
            newPost.setUser(user1);
//        saving post to our postdao
            postDao.save(newPost);
//        }

        return "redirect:/post";

    }
}