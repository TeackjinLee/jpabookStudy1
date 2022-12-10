package com.study.jpabook.jpabook01.api;

import com.study.jpabook.jpabook01.datasource.jpa06.Member3;
import com.study.jpabook.jpabook01.datasource.jpa06.MemberProduct2;
import com.study.jpabook.jpabook01.datasource.jpa06.MemberProductId;
import com.study.jpabook.jpabook01.datasource.jpa06.Product2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author holyeye
 */
public class JpaManyToMany6_4_3 {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            save(em);  //비즈니스 로직
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

        //회원저장
        Member3 member1 = new Member3();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        //상품 저장
        Product2 productA = new Product2();
        productA.setId("productA");
        productA.setName("상품1");
        em.persist(productA);

        //회원상품 저장
        MemberProduct2 memberProduct2 = new MemberProduct2();
        memberProduct2.setMember(member1);      //주문 회원 - 연관관계 설정
        memberProduct2.setProduct(productA);    //주문 상품 - 연관관계 설정
        memberProduct2.setOrderAmount(2);       //주문 수량
        memberProduct2.setOrderDate(null);

        em.persist(memberProduct2);

    }

    //6.24 조회 코드
    // 복합키는 항상 식별자 클래스를 만들어야 한다. ORM 매핑처리할 일이 증가
    public static void find(EntityManager em){
        // 기본 키 값 생성
        MemberProductId memberProductId = new MemberProductId();
        memberProductId.setMember("member1");
        memberProductId.setProduct("productA");

        MemberProduct2 memberProduct2 = em.find(MemberProduct2.class, memberProductId);
        Member3 member = memberProduct2.getMember();
        Product2 product = memberProduct2.getProduct();

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + memberProduct2.getOrderAmount());

    }
}