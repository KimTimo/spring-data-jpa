package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    /**
     * EnumType ORDINAL 절대금지
     * DB에 들어갈 때 index 번호로 들어가는데 만약, READY와 COMP 사이에 상태값이 생긴다면 망한다.
     * 반드시 STRING으로 지정할 것
     */
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;    // READY, COMP
}
