package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(MemberProductId.class)
public class MemberProduct2 {
    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member3 member; //MemberProductId.member와 연결

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product2 product; //MemberProductId.product와 연결

    private int orderAmount;

    private Date orderDate;

    //Getter Setter
    public Member3 getMember() {
        return member;
    }

    public void setMember(Member3 member) {
        this.member = member;
    }

    public Product2 getProduct() {
        return product;
    }

    public void setProduct(Product2 product) {
        this.product = product;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
