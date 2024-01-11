package com.media.socialmedia.Followers;


import com.media.socialmedia.Users.Models;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "followers")
public class FollowersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String FollowerID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Models User;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Follower_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Models Follower;


    public FollowersModel() {
    }

    public FollowersModel(String followerID) {
        FollowerID = followerID;
    }

    public String getFollowerID() {
        return FollowerID;
    }

    public void setFollowerID(String followerID) {
        FollowerID = followerID;
    }

    public FollowersModel(Models user, Models follower) {
        User = user;
        Follower = follower;
    }

    public Models getUser() {
        return User;
    }

    public void setUser(Models user) {
        User = user;
    }

    public Models getFollower() {
        return Follower;
    }

    public void setFollower(Models follower) {
        Follower = follower;
    }

    @Override
    public String toString() {
        return "FollowersModel{" +
                "User=" + User +
                ", Follower=" + Follower +
                '}';
    }
}
