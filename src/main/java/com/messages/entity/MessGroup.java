package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mess_groups")
@Data
public class MessGroup extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "group_user_send")
    private Group group_user_send;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timeSend;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timeRead;

    @Column
    private String content;
}
