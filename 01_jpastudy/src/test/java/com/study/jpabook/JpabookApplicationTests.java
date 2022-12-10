package com.study.jpabook;

import com.study.jpabook.jpabook01.datasource.jap05.Member2;
import com.study.jpabook.jpabook01.datasource.jap05.Team;
import com.study.jpabook.jpabook01.datasource.jpa06.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.util.List;

import static org.assertj.core.util.DateUtil.now;

@SpringBootTest
class JpabookApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testSave() {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
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

    }
    @Test
    public void findMemberAndTeam(){
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
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

        Member2 member = em.find(Member2.class, "member1");
        Team team = member.getTeam(); // 객체 그래프 탐색
        System.out.println("팀 이름 = " + team.getName());
    }

    @Test
    public void biDiretion() {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        Team team = em.find(Team.class, "team1");
        List<Member2> members = team.getMembers(); // (팀 -> 회원) 객체 그래프 탐색
        System.out.println("sssss" + members);
        for ( Member2 member : members) {
            System.out.println("member.username =  " + member.getUsername());
        }
    }

    @Test
    // 5.5 양방향 연관관계 저장
    public void testSave2(){
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();
        // 팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        // 회원1 저장
        Member2 member1 = new Member2("member1", "희원1");
        member1.setTeam(team1); //연관관계 설정 member1 -> team1
        em.persist(member1);

        // 회원2 저장
        Member2 member2 = new Member2("member2", "회원2");
        member2.setTeam(team1); //연관관계 설정 member2 -> team1
        em.persist(member2);
        tx.commit();

    }

    @Test
    // 5.6 양방향 연관관계 주의점
    public void testSaveNonOwner(){
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();
        //회원1 저장
        Member2 member1 = new Member2("member1", "회원1");
        em.persist(member1);
        //회원2 저장
        Member2 member2 = new Member2("member2", "회원2");
        em.persist(member2);

        Team team1 = new Team("team1", "팀1");
        // 주인이 아닌 곳만 연관관계 설정
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(team1);
        tx.commit();
    }

    //5.6.1 순수한 객체까지 고려한 양방향 연관관계
    //5.15 순수한 객체 연관관계
    @Test
    public void test순수한객체_양방향(){

        //팀1
        Team team1 = new Team("team1", "팀1");
        Member2 member1 = new Member2("member1", "회원1");
        Member2 member2 = new Member2("member2", "회원2");

        member1.setTeam(team1);          //연관관계 설정 member1 -> team1
        team1.getMembers().add(member1); //연관관계 설정 team1 -> member1

        member2.setTeam(team1);          //연관관계 설정 member2 -> team1
        team1.getMembers().add(member2); //연관관계 설정 team1 -> member2

        List<Member2> members = team1.getMembers();
        System.out.println("members.size = " + members.size());

    }

    // 5.18 양방향 리팩토링 전체코드
    @Test
    public void testORM_양방향_리팩토링(){

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();

        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member2 member1 = new Member2("member1", "회원1");
        member1.setTeam(team1); //양방향 설정
        em.persist(member1);

        Member2 member2 = new Member2("member2", "회원2");
        member2.setTeam(team1); // 양방향 설정
        em.persist(member2);

        tx.commit();
    }

    //6.7 일대다 단방향 매핑의 단점
    @Test
    public void testsSave(){

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();

        MemberOneToMany member1 = new MemberOneToMany("member1");
        MemberOneToMany member2 = new MemberOneToMany("member2");

        TeamOneToMany team1 = new TeamOneToMany("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(member1);//INSERT-member1
        em.persist(member2);//INSERT-member2
        em.persist(team1);  //INSERT-team1, UPDATE-member1.fk,
                            //UPDATE-member2.fk
        tx.commit();
    }

    //6.15 저장
    @Test
    public void save6(){
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();

        ProductManyToMany productA = new ProductManyToMany();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        MemberManyToMany member1 = new MemberManyToMany();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);    //연관관계 설정
        em.persist(member1);
        tx.commit();
    }

    @Test
    public void find(){
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();
        ProductManyToMany productA = new ProductManyToMany();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        ProductManyToMany productB = new ProductManyToMany();
        productB.setId("productB");
        productB.setName("상품B");
        em.persist(productB);

        MemberManyToMany member1 = new MemberManyToMany();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);    //연관관계 설정
        em.persist(member1);

        MemberManyToMany member = em.find(MemberManyToMany.class, "member1");
        List<ProductManyToMany> products = member.getProducts();    //객체 그래프 탐색
        for(ProductManyToMany productManyToMany : products){
            System.out.println("product.name = " + productManyToMany.getName());
        }

        tx.commit();
    }


    @Test
    public void find22(){
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();
        ProductManyToMany productA = new ProductManyToMany();
        productA.setId("productA");

        em.persist(productA);

        MemberManyToMany member1 = new MemberManyToMany();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);    //연관관계 설정
        em.persist(member1);

        productA.getMembers().add(member1);
        em.persist(productA);

        tx.commit();

        ProductManyToMany product = em.find(ProductManyToMany.class, "productA");
        List<MemberManyToMany> members = product.getMembers();
        for (MemberManyToMany memberManyToMany : members) {
            System.out.println("member = " + memberManyToMany.getUsername());
        }

    }

    // 6.4.3 다대다: 매피으이 한계와 극복, 연결 엔티티 사용
    @Test
    public void save(){
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        tx.begin();
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
        memberProduct2.setOrderDate(now());

        em.persist(memberProduct2);

        tx.commit();
    }

    @Test
    public void find6_24(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        //기본 키 값 생성
        MemberProductId memberProductId = new MemberProductId();
        memberProductId.setMember("member1");
        memberProductId.setProduct("productA");

        MemberProduct2 memberProduct2 = em.find(MemberProduct2.class, memberProductId);

    }

}
