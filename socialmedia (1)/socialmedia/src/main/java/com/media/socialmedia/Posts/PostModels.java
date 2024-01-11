package com.media.socialmedia.Posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.media.socialmedia.Users.Models;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Posts")
public class PostModels {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String PostID;
    private String PostHeaderImage;
    private String PostContent;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "User_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Models userModel;

    public PostModels() {
    }

    public PostModels(String postID, String postHeaderImage, String postContent, Models userModel) {
        PostID = postID;
        PostHeaderImage = postHeaderImage;
        PostContent = postContent;
        this.userModel = userModel;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String postID) {
        PostID = postID;
    }

    public String getPostHeaderImage() {
        return PostHeaderImage;
    }

    public void setPostHeaderImage(String postHeaderImage) {
        PostHeaderImage = postHeaderImage;
    }

    public String getPostContent() {
        return PostContent;
    }

    public void setPostContent(String postContent) {
        PostContent = postContent;
    }

    public Models getUserModel() {
        return userModel;
    }

    public void setUserModel(Models userModel) {
        this.userModel = userModel;
    }

    @Override
    public String toString() {
        return "PostModels{" +
                "PostID=" + PostID +
                ", PostHeaderImage='" + PostHeaderImage + '\'' +
                ", PostContent='" + PostContent + '\'' +
                ", userModel=" + userModel +
                '}';
    }
}
