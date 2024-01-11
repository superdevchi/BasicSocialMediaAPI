package com.media.socialmedia.Followers;

import com.media.socialmedia.Users.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollwersService {

    //inject
    @Autowired
    FollowersRepository followersRepository;


    @Autowired
    Repository userRepository;

    public FollowersModel AddFollower(String USERID, String FOLLOWID, FollowersModel followersModel){
        // check if userexist
        userRepository.findById(USERID).map(MYUSERID ->{
            followersModel.setUser(MYUSERID);
            userRepository.findById(FOLLOWID).map(ADDFOLLOW ->{
                followersModel.setFollower(ADDFOLLOW);
                return "";
            });
            return "";
        });
        return followersRepository.save(followersModel);
    }

    public String removeFollower(String FOLLOWID){
        followersRepository.deleteById(FOLLOWID);
        return "User Removed"+FOLLOWID;
    }

    public List<FollowersModel> list(){
       return followersRepository.findAll();
    }

    public List<FollowersModel> GetAllFollwersByUserID(String ID){
        FollowersModel followersModel = new FollowersModel();
        //check if userExist
        userRepository.findById(ID).map(USERID ->{
            followersModel.setUser(USERID);
//            return followersRepository.GetAllFollowersByUserID(ID);
            return "";
        });

        return followersRepository.GetAllFollowersByUserID(ID);
    }
}



