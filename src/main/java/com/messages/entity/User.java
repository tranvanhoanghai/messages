package com.messages.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User extends BaseEntity
{
    @Column
    private String userImg;

    @Column(length = 100, nullable = false, unique = true)
    @NotBlank(message = "Username cannot be null")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "First name cannot be null")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Last name cannot be null")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "Password cannot be null")
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "Email cannot be null")
    @Email(message = "Must be email")
    private String email;

    @Column(length = 1)
    private String gender;

    @Column()
    private Date dateOfBirth;

//    @Column(length = 1)
//    private String isActive;

    @Column
    private String rememberToken;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user_send", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Messengers> messengers = new ArrayList<>();

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private Set<GroupUser> groupUsers = new HashSet<>();

    @OneToMany(mappedBy = "friend_send", cascade = CascadeType.ALL)
    private Set<Friend> friend_send = new HashSet<>();

    @OneToMany(mappedBy = "friend_reply", cascade = CascadeType.ALL)
    private Set<Friend> friend_reply = new HashSet<>();

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "group_user_send", cascade = CascadeType.ALL)
    private Set<MessGroup> messGroups = new HashSet<>();

    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("costMaterials")
//    @JsonIgnoreProperties("user1")
    private List<Conversation> conversations = new ArrayList<>();

    @OneToMany(mappedBy = "user2",  cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("costMaterials")
//    @JsonIgnoreProperties("user2")
    private List<Conversation> conversations2 = new ArrayList<>();

}
