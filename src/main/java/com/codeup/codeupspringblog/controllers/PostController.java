package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
//import com.codeup.codeupspringblog.models.PostCategories;
//import com.codeup.codeupspringblog.repositories.PostCategoriesRepository;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
//    private final PostCategoriesRepository catDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
//        this.catDao = catDao;
        this.emailService = emailService;
    }

    @GetMapping("/post")
    public String post(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(loggedInUser.getEmail());
        System.out.println(loggedInUser.getId());
        System.out.println(loggedInUser.getUsername());

        model.addAttribute("posts", postDao.findAll());

//        getting useremail using finddbyid method
        String userEmail = userDao.findById(1L).get().getEmail();
        model.addAttribute("email", userEmail);
//        ArrayList <Post> posts = new ArrayList<>();
//        Post myPost = new Post("hey","Hello World");
//        Post thePost = new Post("bye","bye World");
//        posts.add(myPost);
//        posts.add(thePost);
        return "post/index";
    }

    @GetMapping("/post/{id}")
    public String postById(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id).get());
        return "post/show";
    }

    @GetMapping("/post/create")
    public String formPost() {
        return "post/create";
    }

    @PostMapping("/post/create")
    public String postComplete(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = new Post();
        post.setUser(loggedInUser);
        post.setTitle(title);;
        post.setBody(body);
        postDao.save(post);
        emailService.prepareAndSend(post,"hello","hello there");

        return "redirect:/post";
    }



    @GetMapping("/post/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id).get());
        return "post/edit";
    }

    @PostMapping("/post/{id}/edit")
    public String editComplete(@PathVariable long id, @ModelAttribute Post post) {
        postDao.save(post);


        return "redirect:/post";
    }


}








