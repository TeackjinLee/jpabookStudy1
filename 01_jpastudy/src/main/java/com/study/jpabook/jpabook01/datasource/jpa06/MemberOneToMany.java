package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;

@Entity
public class MemberOneToMany {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    public MemberOneToMany(String username) {
        this.username = username;
    }

    //Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
