package com.media.socialmedia.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Comment")
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping("/{USERID}/{POSTID}/create")
    public CommentModels create(@PathVariable String USERID, @PathVariable String POSTID, CommentModels commentModels){
        return commentService.create(USERID, POSTID, commentModels);
    }

    @DeleteMapping("/{COMMENTID}")
    public String delete(@PathVariable String COMMENTID){
        commentService.deleteComment(COMMENTID);

        return "post deleted"+COMMENTID;
    }

    @GetMapping("/comment")
    public List<CommentModels> list(){
        return commentService.list();
    }
}
