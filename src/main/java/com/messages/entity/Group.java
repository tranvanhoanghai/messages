package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
public class Group extends BaseEntity
{
    @Column(nullable = false)
    private String groupName;

    @Column(nullable = false)
    private String groupImg;

    @OneToMany(mappedBy = "group_id", cascade = CascadeType.ALL)
    private List<GroupUser> groupUsers = new ArrayList<>();

    @OneToMany(mappedBy = "group_user_send" )
    private List<MessGroup> messGroups = new ArrayList<>();
}
