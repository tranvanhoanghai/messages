package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
@Data
public class Post extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @OneToMany(mappedBy = "post_id", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @Column(nullable = false)
    private String content_text_img;

    @Column(length = 1, nullable = false)
    private Integer status;
}
