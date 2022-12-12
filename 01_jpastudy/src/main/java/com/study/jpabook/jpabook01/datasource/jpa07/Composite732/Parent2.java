package com.study.jpabook.jpabook01.datasource.jpa07.Composite732;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent2 {

    @EmbeddedId
    private ParentId2 id;

    private String name;

    //Getter, Setter
    public ParentId2 getId() {
        return id;
    }

    public void setId(ParentId2 id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
