package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member4 member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product3 product;

    private int orderAmount;

    //Getter, Setter
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Member4 getMember() {
        return member;
    }

    public void setMember(Member4 member) {
        this.member = member;
    }

    public Product3 getProduct() {
        return product;
    }

    public void setProduct(Product3 product) {
        this.product = product;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}