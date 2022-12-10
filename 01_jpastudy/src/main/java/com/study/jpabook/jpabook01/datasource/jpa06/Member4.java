package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member4 {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<Orders>();

    private String username;


    //Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
