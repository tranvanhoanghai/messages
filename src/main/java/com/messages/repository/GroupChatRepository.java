package com.messages.repository;

import com.messages.entity.Group;
import com.messages.entity.Messengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupChatRepository extends JpaRepository<Group, Integer> {
    @Query(value = "select * " +
            "from Groups g inner join group_user gu on g.id = gu.group_id " +
            "where gu.user_id = :userId ", nativeQuery = true)
    List<Group> getUserGroup(@Param("userId") Integer userId);

    // Lấy tất cả tin nhắn từ Mess Group bởi id group
    @Query(value = "select distinct g.* from Groups g inner join mess_group mg on g.id = mg.group_id where mg.group_id = :idGroup", nativeQuery = true)
    List<Group> getMessByIdGroupChat(@Param("idGroup") Integer idGroup);
}
