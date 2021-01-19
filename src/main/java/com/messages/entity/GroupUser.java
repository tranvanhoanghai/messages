package com.messages.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "groupUsers")
@Data
public class GroupUser extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(length = 1, nullable = false)
    private Integer isAdmin;
}
