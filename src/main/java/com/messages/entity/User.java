package com.messages.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity
{
    @Column
    private String userImg;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, length = 1)
    private Integer gender;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 1)
    private Integer isActive;

    @Column
    private String rememberToken;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user_send", cascade = CascadeType.ALL)
    private List<Messengers> messengers = new ArrayList<>();

    @OneToMany(mappedBy = "user_read", cascade = CascadeType.ALL)
    private List<Messengers> messengers2 = new ArrayList<>();

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<GroupUser> groupUsers = new ArrayList<>();

    @OneToMany(mappedBy = "friend_send", cascade = CascadeType.ALL)
    private List<Friend> friends = new ArrayList<>();

    @OneToMany(mappedBy = "friend_reply", cascade = CascadeType.ALL)
    private List<Friend> friends2 = new ArrayList<>();

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "group_user_send", cascade = CascadeType.ALL)
    private List<MessGroup> messGroups = new ArrayList<>();

    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private List<Conversations> conversations = new ArrayList<>();

    @OneToMany(mappedBy = "user2", cascade = CascadeType.ALL)
    private List<Conversations> conversations2 = new ArrayList<>();

}
