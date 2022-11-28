package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;

@Entity
public class MemberOneToOne {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @OneToOne(mappedBy = "member")
    //@JoinColumn(name = "LOCKER_ID")
    private LockerOneToOne locker;

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

    public LockerOneToOne getLocker() {
        return locker;
    }

    public void setLocker(LockerOneToOne locker) {
        this.locker = locker;
    }
}
