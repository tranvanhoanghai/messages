package com.messages.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

@Entity
@Table(name = "groupUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class GroupUser extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(length = 1, nullable = false)
    private Integer isAdmin;
}
