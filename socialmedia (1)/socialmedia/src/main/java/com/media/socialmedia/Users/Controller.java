package com.media.socialmedia.Users;


import com.media.socialmedia.Posts.PostModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("User")
public class Controller {


    //inject
    @Autowired
    Service service;
    @PostMapping("/create")
    public Models create(@ModelAttribute Models models, @PathVariable(value = "file", required = false)MultipartFile ImageFile){
        return service.CreateUser(models,ImageFile);
    }

    @GetMapping("/{USERID}")
    public List<PostModels> get(@PathVariable String USERID){
        //get all users post
        return service.GetUserPosts(USERID);
    }

    @GetMapping("/List")
    public List<Models>list(){
        return service.ListUsers();
    }
}
