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

    @Query("SELECT u FROM User u WHERE NOT u.id=?1")
    List<User> listExceptUserChat (Integer exceptUsername);
}
