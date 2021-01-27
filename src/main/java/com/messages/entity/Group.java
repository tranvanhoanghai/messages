package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<GroupUser> groupUsers = new HashSet<>();

    @OneToMany(mappedBy = "group_id", cascade = CascadeType.ALL)
    private Set<MessGroup> messGroups = new HashSet<>();
}
