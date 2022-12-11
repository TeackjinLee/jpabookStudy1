package com.study.jpabook.jpabook01.datasource.jpa07.MappedSuperClass;

import javax.persistence.Entity;

@Entity
public class Seller extends BaseEntity {
    //ID 상속
    //NAME 상속
    private String shopName;

    //Getter, Setter
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
