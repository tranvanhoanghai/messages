package com.messages.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "friends")
@Data
public class Friend extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "friend_send")
    private User friend_send;

    @ManyToOne
    @JoinColumn(name = "friend_reply")
    private User friend_reply;

    @Column(nullable = false, length = 1)
    private Integer status;
}
