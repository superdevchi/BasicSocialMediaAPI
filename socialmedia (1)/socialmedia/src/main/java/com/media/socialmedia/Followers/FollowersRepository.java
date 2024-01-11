package com.media.socialmedia.Followers;

import com.media.socialmedia.Comments.CommentModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersRepository extends JpaRepository<FollowersModel,String> {

    @Query(value = "select * from Followers where user_id=?1 ", nativeQuery = true)
    List<FollowersModel> GetAllFollowersByUserID(String ID);
}
