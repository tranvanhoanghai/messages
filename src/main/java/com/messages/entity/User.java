package com.messages.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity
{
    @Column
    private String userImg;

    @Column(length = 100, nullable = false, unique = true)
    @NotBlank(message = "username cannot be null")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Full name cannot be null")
    private String fullName;

    @Column(nullable = false)
    @NotBlank(message = "password cannot be null")
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "email cannot be null")
    @Email(message = "phải là email")
    private String email;

    @Column(length = 1)
    private String gender;

    @Column()
    private Date dateOfBirth;

    @Column(length = 1)
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

    public User(String username, String fullName, String email, String userImg, String isActive, Integer id, Date dateOfBirth, String gender, String password, List<GrantedAuthority> grantedAuthorities) {
    }
}
