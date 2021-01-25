package com.messages.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "friend")
@Data
public class Friend extends BaseEntity
{
    @Column(nullable = false, length = 1)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "friend_reply")
    private User friend_reply;

    @ManyToOne
    @JoinColumn(name = "friend_send")
    private User friend_send;
}
