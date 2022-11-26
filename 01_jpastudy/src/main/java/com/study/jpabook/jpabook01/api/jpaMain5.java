package com.study.jpabook.jpabook01.api;

import com.study.jpabook.jpabook01.datasource.jap05.Member2;
import com.study.jpabook.jpabook01.datasource.jap05.Team;

public class jpaMain5 {
    public static void main(String[] args) {
        //생성자(id, 이름)
        Member2 member1 = new Member2("member1", "회원1");
        Member2 member2 = new Member2("member2", "회원2");
        Team team1 = new Team("team1", "팀1");

        member1.setTeam(team1);
        member2.setTeam(team1);

        Team findTeam = member1.getTeam();
    }
}
