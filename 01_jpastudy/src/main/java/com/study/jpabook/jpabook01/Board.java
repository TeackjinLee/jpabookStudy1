package com.study.jpabook.jpabook01;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "BOARD_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
// @SequenceGenerator
// name 식별자 생성기 이름 (필수)
// sequenceName 데이터베이스에 등록되어 있는 시퀀스 이름 (hibernate_sequence)
// initialValue DDL 생성 시에만 사용됨. 시퀀스 DDL을 생성할 떄 처음 시작하는 수를 지정한다 (1)
// allocationSize 시퀀스 한번 호출에 증가하는 수(성능 최적화에 사용됨) 50이 기본값
// catalog.schema 데이터베이스 catalog.schema 이름
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "BOARD_SEQ_GENERATOR")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
