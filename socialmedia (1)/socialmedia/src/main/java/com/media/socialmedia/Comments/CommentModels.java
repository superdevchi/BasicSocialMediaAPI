package com.media.socialmedia.Comments;

import com.media.socialmedia.Posts.PostModels;
import com.media.socialmedia.Users.Models;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Comments")
public class CommentModels {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String CommentID;
    private String Comment;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "User_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Models userModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Post_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostModels postModels;

    public CommentModels() {
    }

    public CommentModels(String commentID, String comment, Models userModel, PostModels postModels) {
        CommentID = commentID;
        Comment = comment;
        this.userModel = userModel;
        this.postModels = postModels;
    }

    public String getCommentID() {
        return CommentID;
    }

    public void setCommentID(String commentID) {
        CommentID = commentID;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Models getUserModel() {
        return userModel;
    }

    public void setUserModel(Models userModel) {
        this.userModel = userModel;
    }

    public PostModels getPostModels() {
        return postModels;
    }

    public void setPostModels(PostModels postModels) {
        this.postModels = postModels;
    }

    @Override
    public String toString() {
        return "CommentModels{" +
                "CommentID=" + CommentID +
                ", Comment='" + Comment + '\'' +
                ", userModel=" + userModel +
                ", postModels=" + postModels +
                '}';
    }
}
