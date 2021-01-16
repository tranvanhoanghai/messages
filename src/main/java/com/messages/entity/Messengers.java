package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messengers")
@Data
public class Messengers extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "user_send")
    private User user_send;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timeSend;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timeRead;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length = 1)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "cvt_id")
    private Conversation cvt_id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group_id;
}
