package com.media.socialmedia.Followers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Follow")
public class FollowerController {

    @Autowired
    FollwersService follwersService;

    @PostMapping("/{USERID}/{FOLLOWERUSERID}")
    public FollowersModel add(@PathVariable String USERID, @PathVariable String FOLLOWERUSERID, FollowersModel followersModel){
        return follwersService.AddFollower(USERID, FOLLOWERUSERID, followersModel);
    }

    @GetMapping("/")
    public List<FollowersModel>list(){
        return follwersService.list();
    }

    @GetMapping("/{USERID}")
    public List<FollowersModel>GetFollowerByUserID(@PathVariable String USERID){
       return follwersService.GetAllFollwersByUserID(USERID);
    }

    @DeleteMapping("/{FOLLOWID}")
    public String delete(@PathVariable String FOLLOWID){
        follwersService.removeFollower(FOLLOWID);

        return "post deleted"+FOLLOWID;
    }
}
