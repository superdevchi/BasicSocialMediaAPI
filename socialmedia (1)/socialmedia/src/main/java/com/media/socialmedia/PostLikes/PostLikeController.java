package com.media.socialmedia.PostLikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Likes")
public class PostLikeController {

    @Autowired
    PostLikeService postLikeService;


    @PostMapping("/{USERID}/{POST_ID}/like")
    public PostLikeModel create(@PathVariable String USERID, @PathVariable String POST_ID, PostLikeModel postLikeModel){
        return postLikeService.create(USERID, POST_ID, postLikeModel);
    }
    @GetMapping("/{POSTID}")
    public List<PostLikeModel>GetAllLikesOnPost(@PathVariable String POSTID){
        return postLikeService.GetAllPostLikesByPostID(POSTID);
    }

    @GetMapping("/")
    public List<PostLikeModel>list(@PathVariable String POSTID){
        return postLikeService.list();
    }



}


