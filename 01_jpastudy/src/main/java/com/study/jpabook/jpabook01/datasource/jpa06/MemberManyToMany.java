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
}
