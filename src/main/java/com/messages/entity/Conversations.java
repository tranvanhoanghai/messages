package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversations")
@Data
public class Conversations extends BaseEntity
{

    @ManyToOne
    @JoinColumn(name = "user1")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2")
    private User user2;

    @OneToMany(mappedBy = "cvt_id", cascade = CascadeType.ALL)
    private List<Messengers> messengers = new ArrayList<>();
}
