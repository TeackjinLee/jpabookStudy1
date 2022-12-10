package com.study.jpabook.jpabook01.api;

import com.study.jpabook.jpabook01.datasource.jpa06.Member4;
import com.study.jpabook.jpabook01.datasource.jpa06.MemberProductId;
import com.study.jpabook.jpabook01.datasource.jpa06.Orders;
import com.study.jpabook.jpabook01.datasource.jpa06.Product3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author holyeye
 */
public class JpaManyToMany6_4_4 {

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

        //회원저장
        Member4 member1 = new Member4();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        //상품 저장
        Product3 productA = new Product3();
        productA.setId("productA");
        productA.setName("상품1");
        em.persist(productA);

        //주문 저장
        Orders order = new Orders();
        order.setMember(member1);   //주문회원 - 연관관계 설정
        order.setProduct(productA); //주문상품 - 연관관계 설정
        order.setOrderAmount(2);    //주문 수량
        em.persist(order);

    }

    //6.24 조회 코드
    // 복합키는 항상 식별자 클래스를 만들어야 한다. ORM 매핑처리할 일이 증가
    public static void find(EntityManager em){
        Long orderId = 1L;
        Orders order = em.find(Orders.class, orderId);

        Member4 member = order.getMember();
        Product3 product = order.getProduct();

        MemberProductId memberProductId = new MemberProductId();
        memberProductId.setMember("member1");
        memberProductId.setProduct("productA");

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + order.getOrderAmount());

    }
}