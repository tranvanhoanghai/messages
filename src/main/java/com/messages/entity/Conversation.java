package com.messages.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversation")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Conversation extends BaseEntity
{
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user1")
//    @JsonBackReference
    private User user1;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user2")
//    @JsonBackReference
    private User user2;

    @OneToMany(mappedBy = "cvt_id", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Messengers> messengers = new ArrayList<>();

}
