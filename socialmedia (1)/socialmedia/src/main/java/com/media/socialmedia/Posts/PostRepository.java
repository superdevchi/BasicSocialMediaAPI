package com.media.socialmedia.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModels,String> {

    @Query(value = "select * from Posts where user_id=?1 ", nativeQuery = true)
    List<PostModels> GetAllPostByUSERID(String ID);
}
