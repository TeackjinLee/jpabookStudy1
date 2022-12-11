package com.study.jpabook.jpabook01.datasource.jpa07.SingleTable;

import com.study.jpabook.jpabook01.datasource.jpa07.joinMapping.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    private String diretor; //감독
    private String actor;   //배우

    //Getter, Setter
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
