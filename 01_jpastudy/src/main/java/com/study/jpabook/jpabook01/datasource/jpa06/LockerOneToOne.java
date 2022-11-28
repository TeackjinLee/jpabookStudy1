package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;

@Entity
public class LockerOneToOne {
    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "MEMBER_ID")
    private MemberOneToOne member;

    //Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
