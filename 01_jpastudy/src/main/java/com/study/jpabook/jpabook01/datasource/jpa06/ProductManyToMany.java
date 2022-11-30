package com.study.jpabook.jpabook01.datasource.jpa06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ProductManyToMany {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "products")  //역방향 추가
    private List<MemberManyToMany> members;

    //Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberManyToMany> getMembers() {
        return members;
    }

    public void setMembers(List<MemberManyToMany> members) {
        this.members = members;
    }
}
