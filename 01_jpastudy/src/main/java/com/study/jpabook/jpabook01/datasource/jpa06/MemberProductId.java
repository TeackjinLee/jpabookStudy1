package com.study.jpabook.jpabook01.datasource.jpa06;

import java.io.Serializable;

public class MemberProductId implements Serializable {
    private String member;  //MemberProduct.member와 연결
    private String product; //MemberProduct.product와 연결

    //hashCode and equals


    //Getter Setter
    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
