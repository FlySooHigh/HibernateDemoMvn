package org.flysoohigh.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "payment_type")
    private String type;
    @ManyToMany
    @JoinTable(name = "payment_origin",
        joinColumns = {@JoinColumn(name = "payment_id")},
        inverseJoinColumns = {@JoinColumn(name = "origin_id")})
    private List<Payment> originPayments = new ArrayList<>();

    public Payment() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Payment> getOriginPayments() {
        return originPayments;
    }

    public void setOriginPayments(List<Payment> originPayments) {
        this.originPayments = originPayments;
    }
}
