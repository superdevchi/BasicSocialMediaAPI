package com.media.socialmedia.Posts;


import com.media.socialmedia.Comments.CommentModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Post")
public class PostController {

    @Autowired
    PostService postService;


    //create User
    @PostMapping("/{USERID}/create")
    public PostModels create(@PathVariable String USERID, @ModelAttribute PostModels postModels, @PathVariable("file")MultipartFile ImageFile){

        return postService.create(USERID, postModels, ImageFile);
    }

    @GetMapping("posts")
    public List<PostModels> get(){
        return postService.GetAllPost();
    }

    //get all comment on a post
    @GetMapping("/{POSTID}")
    public List<CommentModels> GetAllPostComments(@PathVariable String POSTID){
        return postService.GetAllCommentOnPost(POSTID);
    }

    @DeleteMapping("/{POSTID}")
    public String delete(@PathVariable String POSTID){
        postService.deletePost(POSTID);

        return "post deleted"+POSTID;
    }

    @GetMapping("/{POSTID}/search")
    public Optional<PostModels>search(@PathVariable String POSTID){
        return postService.GetPostByID(POSTID);
    }


}
