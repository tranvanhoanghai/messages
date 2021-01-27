package com.messages.repository;

import com.messages.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByUsername(String username);

    @Query(value = "select * " +
            "from User u, friend f " +
            "where ((f.friend_send = ?1 and u.id = friend_reply) or (f.friend_reply = ?1 and u.id = friend_send)) and (f.status = 1 or f.status = 0) ", nativeQuery = true)
    List<User> listExceptUserChat (Integer exceptUsername); // lấy user nằm trong list bạn bè ngoại trừ user login

    List<User> findByFirstName(String key);

}
