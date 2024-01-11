package com.media.socialmedia.Posts;

import com.media.socialmedia.Comments.CommentModels;
import com.media.socialmedia.Comments.CommentRepository;
import com.media.socialmedia.Users.AWSIMAGEUPLOAD;
import com.media.socialmedia.Users.Models;
import com.media.socialmedia.Users.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    //inject users repository to check for existing user
    @Autowired
    Repository repository;

    @Autowired
    AWSIMAGEUPLOAD awsimageupload;

    //inject post repository
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    public PostModels create(String ModelID,PostModels postModels, MultipartFile File){
        //check if userExist
      repository.findById(ModelID).map(usermodel ->{
          postModels.setUserModel(usermodel);

          //check if file empty
          MultipartFile Null = null;
          if(Null == File){
              postModels.setPostHeaderImage("");
          }

          awsimageupload.uploadFileImage(File);
          postModels.setPostHeaderImage(awsimageupload.GETURLIMAGE());

          return "UserExist and posting";
      });

        return postRepository.save(postModels);
    }

    public String deletePost(String POSTID){
       postRepository.deleteById(POSTID);
        return "Post deleted"+POSTID;
    }
    public Optional<PostModels> GetPostByID(String ID){
        return postRepository.findById(ID);
    }

    public List<PostModels> GetAllPost(){
        return postRepository.findAll();
    }


    //get all comment on a post
    public List<CommentModels> GetAllCommentOnPost(String ID){

        //comment model
        CommentModels commentModels = new CommentModels();

        //check if post Exist
        postRepository.findById(ID).map(POST ->{
            commentModels.setPostModels(POST);
            return commentRepository.GetAllCommentByPostID(ID);
        });

        return commentRepository.GetAllCommentByPostID(ID);
    }
}
