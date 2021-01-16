package com.messages.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "friends")
@Data
public class Friend extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "friend1")
    private User friend1;

    @ManyToOne
    @JoinColumn(name = "friend2")
    private User friend2;

    @Column(nullable = false, length = 1)
    private Integer status;
}
