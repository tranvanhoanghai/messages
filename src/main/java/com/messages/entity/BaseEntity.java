package com.messages.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
@Data
public class BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;

}
