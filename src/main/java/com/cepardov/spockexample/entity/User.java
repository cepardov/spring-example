package com.cepardov.spockexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date created;

    private Date updated;

    @PrePersist
    private void prePersist(){
        this.created = new Date();
    }

    @PreUpdate
    private void preUpdate(){
        this.updated = new Date();
    }
}
