package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberManyToMany {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",
                joinColumns = @JoinColumn(name = "MEMBER_ID"),
                inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<ProductManyToMany> products = new ArrayList<ProductManyToMany>();

//    public void addProduct(ProductManyToMany productManyToMany){
//        products.add(productManyToMany);
//        productManyToMany.getMembers().add(this);
//    }

    //Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ProductManyToMany> getProducts() {
        return products;
    }

    public void setProducts(List<ProductManyToMany> products) {
        this.products = products;
    }
}
