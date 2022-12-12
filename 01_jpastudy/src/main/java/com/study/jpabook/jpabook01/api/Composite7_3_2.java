package com.study.jpabook.jpabook01.api;

import com.study.jpabook.jpabook01.datasource.jpa06.Member4;
import com.study.jpabook.jpabook01.datasource.jpa06.MemberProductId;
import com.study.jpabook.jpabook01.datasource.jpa06.Orders;
import com.study.jpabook.jpabook01.datasource.jpa06.Product3;
import com.study.jpabook.jpabook01.datasource.jpa07.Composite732.Parent;
import com.study.jpabook.jpabook01.datasource.jpa07.Composite732.ParentId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author holyeye
 */
public class Composite7_3_2 {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            save(em);
            tx.commit();//트랜잭션 커밋
            find(em);

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void save(EntityManager em) {

        Parent parent = new Parent();
        parent.setId1("myId1"); //식별자
        parent.setName("parentName");
        em.persist(parent);

    }

    public static void find(EntityManager em){
        ParentId parentId = new ParentId("myId1", "myId2");
        Parent parent = em.find(Parent.class, parentId);
    }
}