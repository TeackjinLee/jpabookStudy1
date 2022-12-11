package com.study.jpabook.jpabook01.datasource.jpa07.MappedSuperClass;

import javax.persistence.Entity;

@Entity
public class Member extends BaseEntity{
    //ID 상속
    //NAME 상속
    private String email;

    //Getter, Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
