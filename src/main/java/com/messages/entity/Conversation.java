package com.messages.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Conversation extends BaseEntity
{
    @ManyToOne()
    @JoinColumn(name = "user1")
//    @JsonBackReference
    private User user1;

    @ManyToOne()
    @JoinColumn(name = "user2")
//    @JsonBackReference
    private User user2;

    @OneToMany(mappedBy = "cvt_id", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Messengers> messengers = new ArrayList<>();

}
