package com.messages.repository;

import com.messages.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
    // check conversation đã có 2 user chat chưa
    @Query(value = "select * " +
            " from Friend f " +
            " where ((f.friend_send = :friend_send and f.friend_reply = :friend_reply) or ((f.friend_send = :friend_reply and f.friend_reply = :friend_send))", nativeQuery = true)
    Friend checkFriend (@Param("friend_send") Integer friend_send, @Param("friend_reply") Integer friend_reply);

    @Modifying // jpa không hỗ trợ native insert nên phải dùng kèm Annotation @Modifying
    @Transactional
    @Query(value = "insert into Friend (friend_send, friend_reply) values (:friend_send, :friend_reply)", nativeQuery = true)
    void saveFriend (@Param("friend_send") Integer friend_send, @Param("friend_reply") Integer friend_reply);
}
