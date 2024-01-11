package com.media.socialmedia.Comments;

import com.media.socialmedia.Posts.PostRepository;
import com.media.socialmedia.Users.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    Repository userRepository;

    public CommentModels create(String UserID, String PostID, CommentModels commentModels){
        //checking user making post
        userRepository.findById(UserID)
                .map(USERMODEL ->{
                    commentModels.setUserModel(USERMODEL);
                    //check if post Exist
                    postRepository.findById(PostID).map(POSTMODEL ->{
                       commentModels.setPostModels(POSTMODEL);
                        return "Post Exist Posting Comment";
                    });
                    return "userExist Uploading Comment";
                });
        return commentRepository.save(commentModels);
    }

    public List<CommentModels> list(){
        return commentRepository.findAll();
    }

    public String deleteComment(String COMMENTID){
        postRepository.deleteById(COMMENTID);
        return "Post deleted"+COMMENTID;
    }
}
