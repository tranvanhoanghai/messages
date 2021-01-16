package com.messages.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private User blog_id;

    @Column(nullable = false)
    private String content;
}
