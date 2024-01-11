package com.media.socialmedia.PostLikes;

import com.media.socialmedia.Posts.PostRepository;
import com.media.socialmedia.Users.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikeService {

    @Autowired
    PostLikeRepository postLikeRepository;

    @Autowired
    Repository Userrepository;

    @Autowired
    PostRepository postRepository;


    public PostLikeModel create(String USERID, String POST_ID, PostLikeModel postLikeModel){
        //check if user exist
        Userrepository.findById(USERID).map(USER ->{
           postLikeModel.setUserThatLikedPost(USER);
           //check if post exist
            postRepository.findById(POST_ID).map(POST ->{
                postLikeModel.setPostLiked(POST);
                return "";
            });
            return "";
        });
       return postLikeRepository.save(postLikeModel);
    }

    public List<PostLikeModel>list(){
        return postLikeRepository.findAll();
    }

    public List<PostLikeModel> GetAllPostLikesByPostID(String ID){
        return postLikeRepository.GetAllPostLikesByPostID(ID);
    }
}
