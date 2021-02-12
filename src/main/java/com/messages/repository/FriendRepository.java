package com.messages.repository;

import com.messages.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
    // check conversation đã có 2 user chat chưa
//    @Query(value = "select * " +
//            " from Friend f " +
//            " where ((f.friend_send = :friend_send and f.friend_reply = :friend_reply) or (f.friend_send = :friend_reply and f.friend_reply = :friend_send))", nativeQuery = true)
//    Friend checkFriend (@Param("friend_send") Integer friend_send, @Param("friend_reply") Integer friend_reply);
//
//    @Modifying // jpa không hỗ trợ native insert nên phải dùng kèm Annotation @Modifying
//    @Transactional
//    @Query(value = "insert into Friend (friend_send, friend_reply) values (:friend_send, :friend_reply)", nativeQuery = true)
//    void saveFriend (@Param("friend_send") Integer friend_send, @Param("friend_reply") Integer friend_reply);

    // Count the user's friends
    @Query(value = "select count(*) from friend f where (f.friend_send = :idUser or f.friend_reply = :idUser) and f.status = 2", nativeQuery = true)
    Integer countFriend(@Param("idUser") Integer idUser);

    // Check user block
    @Query(value = "select * " +
            " from Friend f " +
            " where ((f.friend_send = :friend_send and f.friend_reply = :friend_reply) or (f.friend_send = :friend_reply and f.friend_reply = :friend_send)) and f.status = 3 ", nativeQuery = true)
    Friend checkFriendBlock(@Param("friend_send") Integer friend_send, @Param("friend_reply") Integer friend_reply);
}
