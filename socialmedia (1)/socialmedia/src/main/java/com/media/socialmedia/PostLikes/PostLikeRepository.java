package com.media.socialmedia.PostLikes;

import com.media.socialmedia.Posts.PostModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLikeModel, String> {

    @Query(value = "select * from post_likes where PostLikedID=?1 ", nativeQuery = true)
    List<PostLikeModel> GetAllPostLikesByPostID(String ID);

}
