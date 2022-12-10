package com.study.jpabook.jpabook01.api;

import com.study.jpabook.jpabook01.datasource.jap05.Member2;
import com.study.jpabook.jpabook01.datasource.jap05.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaMain5_crud {
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작

            // 팀1 저장
            Team team1 = new Team("team1", "팀1");
            em.persist(team1);

            // 회원1 저장
            Member2 member1 = new Member2("member1", "회원1");
            member1.setTeam(team1); // 연관관계 설정 member1 -> team1
            em.persist(member1);

            // 회원2 저장
            Member2 member2 = new Member2("member2", "회원2");
            member2.setTeam(team1); // 연관관계 설정 member2 -> team1
            em.persist(member2);
            updateRelation(em);

            tx.commit();//트랜잭션 커밋
            queryLogicJoin(em);

            queryLogicJoin(em);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private static void queryLogicJoin(EntityManager em){

        String jpql = "select m from Member3 m join m.team t where t.name=:teamName";
        List<Member2> resultList = em.createQuery(jpql, Member2.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for (Member2 member : resultList) {
            System.out.println("[query] member.username = " + member.getUsername());
        }
    }

    private static void updateRelation(EntityManager em){

        // 새로운 팀2
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        // 회원1에 새로운 팀2 설정
        Member2 member = em.find(Member2.class, "member1");
        member.setTeam(team2);
    }
}
