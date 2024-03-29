package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 컬렉션은 필드에서 초기화 하는 것이 안전하다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
