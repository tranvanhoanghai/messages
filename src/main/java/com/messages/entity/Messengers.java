package com.messages.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messenger")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Messengers extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "user_send")
//    @JsonBackReference
    private User user_send;

    @ManyToOne
    @JoinColumn(name = "cvt_id")
//    @JsonBackReference
    private Conversation cvt_id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSend;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeRead;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length = 1)
    private String isRead;
}
