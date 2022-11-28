package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamOneToMany {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID") //MEMBER 테이블의 TEAM_ID (FK)
    private List<MemberOneToMany> members = new ArrayList<MemberOneToMany>();

    public TeamOneToMany(String name) {
        this.name = name;
    }

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

    public List<MemberOneToMany> getMembers() {
        return members;
    }

    public void setMembers(List<MemberOneToMany> members) {
        this.members = members;
    }
}
