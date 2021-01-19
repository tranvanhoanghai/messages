package com.messages.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
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

    @Column(nullable = true, length = 1)
    private String gender;

    @Column()
    private Date dateOfBirth;

    @Column(nullable = true, unique = true, length = 100)
    private String email;

    @Column(nullable = true, length = 1)
    private String isActive;

    @Column
    private String rememberToken;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

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


    public User(String username, String fullName, String email, String password) {
        super();
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }


}
