package com.media.socialmedia.PostLikes;

import com.media.socialmedia.Posts.PostModels;
import com.media.socialmedia.Users.Models;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "PostLikes")
public class PostLikeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String PostLikeID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "UserThatLikedPostID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Models UserThatLikedPost;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "PostLikedID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public PostModels PostLiked;

    public PostLikeModel() {
    }

    public PostLikeModel(String postLikeID, Models userThatLikedPost, PostModels postLiked) {
        PostLikeID = postLikeID;
        UserThatLikedPost = userThatLikedPost;
        PostLiked = postLiked;
    }

    public String getPostLikeID() {
        return PostLikeID;
    }

    public void setPostLikeID(String postLikeID) {
        PostLikeID = postLikeID;
    }

    public Models getUserThatLikedPost() {
        return UserThatLikedPost;
    }

    public void setUserThatLikedPost(Models userThatLikedPost) {
        UserThatLikedPost = userThatLikedPost;
    }

    public PostModels getPostLiked() {
        return PostLiked;
    }

    public void setPostLiked(PostModels postLiked) {
        PostLiked = postLiked;
    }

    @Override
    public String toString() {
        return "PostLikeModel{" +
                "PostLikeID='" + PostLikeID + '\'' +
                ", UserThatLikedPost=" + UserThatLikedPost +
                ", PostLiked=" + PostLiked +
                '}';
    }
}
