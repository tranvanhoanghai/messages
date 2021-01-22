package com.messages.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt = new Date();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt = new Date();

}
