package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamManyToOne {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<MemberManyToOne> members = new ArrayList<MemberManyToOne>();

    public void addMember(MemberManyToOne member){
        this.members.add(member);
        if(member.getTeam() != this){   //무한루프에 빠지지 않도록 체크
            member.setTeam(this);
        }
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

    public List<MemberManyToOne> getMembers() {
        return members;
    }

    public void setMembers(List<MemberManyToOne> members) {
        this.members = members;
    }
}
