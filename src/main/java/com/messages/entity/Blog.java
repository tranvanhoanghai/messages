package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
@Data
public class Blog extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @OneToMany(mappedBy = "blog_id", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Column(nullable = false)
    private String content_text_img;
    private String text;
    @Column(length = 1)
    private Integer status;
}
