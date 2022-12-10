package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member3 {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    //역방향
    @OneToMany(mappedBy = "member")
    private List<MemberProduct2> memberProducts2;

    private String username;


    //Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MemberProduct2> getMemberProducts2() {
        return memberProducts2;
    }

    public void setMemberProducts2(List<MemberProduct2> memberProducts2) {
        this.memberProducts2 = memberProducts2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
