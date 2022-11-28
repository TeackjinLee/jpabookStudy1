package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;

@Entity
public class MemberManyToOne {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TeamManyToOne team;

    //Getter, Setter...
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

    public TeamManyToOne getTeam() {
        return team;
    }

    public void setTeam(TeamManyToOne team) {
        this.team = team;
        //무한루프에 빠지지 않도록 체크
        if(!team.getMembers().contains(this)){
            team.getMembers().add(this);
        }
    }
}
