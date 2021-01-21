package com.messages.repository;

import com.messages.entity.Conversations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends JpaRepository<Conversations, Integer> {
    @Query("SELECT c FROM Conversations c WHERE (c.user1 = :user1 AND c.user2 = :user2) OR  (c.user1 = :user2 AND c.user2 = :user1)")
    Conversations checkConvt (@Param("user1") Integer user1, @Param("user2") Integer user2);
}
