package com.study.jpabook.jpabook01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain3 {

    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();    // [트랜잭션] 시작

        // 영속 엔티티 데이터 수정
        Member memberA = em.find(Member.class, "1");

        // 영속 엔티티 데이터 수정
        memberA.setUsername("hi");
        memberA.setAge(10);

        //em.update(member) 이런 코드가 있어야 하지 않을까?

        transaction.commit(); // [트랜잭션] 커밋
    }
}
