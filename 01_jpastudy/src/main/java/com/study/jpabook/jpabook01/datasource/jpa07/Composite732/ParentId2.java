package com.study.jpabook.jpabook01.datasource.jpa07.Composite732;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParentId2 implements Serializable {

    @Column(name = "PARENT_ID1")
    private String id1;
    @Column(name = "PARENT_ID2")
    private String id2;

    public ParentId2(){

    }

    public ParentId2(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    //equals and hashCoe 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentId2 parentId2 = (ParentId2) o;
        return Objects.equals(id1, parentId2.id1) && Objects.equals(id2, parentId2.id2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }
}
