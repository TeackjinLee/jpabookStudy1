package com.study.jpabook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamMergeMain {

    static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {

        Member member = createMember("member2", "회원2");

        member.setUsername("회원명변경");

        mergeMember(member);
    }

    static Member createMember(String id, String username){
        //== 영속성 컨텍스트1 시작 ==//
        EntityManager eml = emf.createEntityManager();
        EntityTransaction txl = eml.getTransaction();
        txl.begin();

        Member member = new Member();
        member.setId(id);
        member.setUsername(username);

        eml.persist(member);
        txl.commit();

        eml.close(); // 영속성 컨텍스트1 종료,
                     // member 엔티티는 준영속 상태가 된다.
        //== 영속성 컨텍스트1 종료 ==//

        return member;
    }

    static void mergeMember (Member member){
        //== 영속성 컨텍스트2 시작 ==//
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member mergeMember = em2.merge((member));
        tx2.commit();

        // 준영속 상태
        System.out.println("member = " + member.getUsername());

        // 영속 상태
        System.out.println("member = " + member.getUsername());

        System.out.println("em2 contains member = " + em2.contains(member));

        System.out.println("em2 contains mergeMember = " + em2.contains(mergeMember));

        em2.close();
        //== 영속성 컥텍스트2 종료==//
    }

}
