package com.media.socialmedia.Users;

import com.media.socialmedia.Posts.PostModels;
import com.media.socialmedia.Posts.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    //inject
    @Autowired
    Repository repository;

    @Autowired
    AWSIMAGEUPLOAD awsimageupload;

    @Autowired
    PostRepository postRepository;

    public Models CreateUser(Models models, MultipartFile File){

        MultipartFile Null = null;
        if(Null == File){
            models.setProfilePicture("");

        }else {
        awsimageupload.uploadFileImage(File);
        String imageURL = awsimageupload.GETURLIMAGE();

        models.setProfilePicture(imageURL);


        }
        return repository.save(models);

    }

    public List<Models> ListUsers(){
        return repository.findAll();
    }

    public Optional<Models> GetUserByUUID(String ID){
        return repository.findById(ID);
    }




    //get all posts from a user ID
    public List<PostModels> GetUserPosts(String ID){
        PostModels postModels = new PostModels();
        //check if user Exist
        repository.findById(ID).map(USERID ->{
            postModels.setUserModel(USERID);
           return postRepository.GetAllPostByUSERID(ID);
//            return "user exist";
        });
        return postRepository.GetAllPostByUSERID(ID);
    }

}
