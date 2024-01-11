package com.media.socialmedia.Comments;

import com.media.socialmedia.Posts.PostModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentModels, String> {

    @Query(value = "select * from Comments where post_id=?1 ", nativeQuery = true)
    List<CommentModels> GetAllCommentByPostID(String ID);
}
