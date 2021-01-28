package com.messages.repository;

import com.messages.entity.Messengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface MessengersRepository extends JpaRepository<Messengers, Integer>
{
    // Lấy tất cả tin nhắn từ id Conversation
//    inner join Conversation c on m.cvt_id = c.id
    @Query(value = "select * from Messenger m  where m.cvt_id=?1", nativeQuery = true)
    List<Messengers> getMessByIdConversation(Integer idConversation);

    // Lưu nội dung tin nhắn
    @Modifying // jpa không hỗ trợ native insert nên phải dùng kèm Annotation @Modifying
    @Transactional
    @Query(value = "insert into Messenger (cvt_id, user_send, time_send, content, is_read) values (:cvt_id, :user_send, :time_send, :content, 0)", nativeQuery = true)
    void saveMess(@Param("cvt_id") Integer cvt_id, @Param("user_send") Integer user_send, @Param("time_send") Date time_send, @Param("content") String content);
}
