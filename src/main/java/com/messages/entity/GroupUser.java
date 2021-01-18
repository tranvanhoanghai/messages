package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupUsers")
@Data
public class GroupUser extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group_id;

    @ManyToOne
    @JoinColumn(name = "group_user_send")
    private Group group_user_send;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(length = 1, nullable = false)
    private Integer isAdmin;
}
