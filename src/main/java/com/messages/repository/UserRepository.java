package com.messages.repository;

import com.messages.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    // Tìm username login
    User findByUsername(String username);

    // lấy user nằm trong list bạn bè ngoại trừ user login
    @Query(value = "select * " +
            "from User u, friend f " +
            "where ((f.friend_send = ?1 and u.id = friend_reply) or (f.friend_reply = ?1 and u.id = friend_send)) and (f.status = 1 or f.status = 0) ", nativeQuery = true)
    List<User> listExceptUserChat (Integer exceptUsername);

    // search user
    List<User> findByFirstName(String key);

    @Transactional
    @Modifying
    @Query(value = "UPDATE User u set user_img = :userImg where u.id = :userId", nativeQuery = true)
    void updateUserImg(@Param("userImg") String userImg, @Param("userId") Integer userId);

}
