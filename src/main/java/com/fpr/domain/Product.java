package com.fpr.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;
//
//    private String productName;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    private String savingsLimit;
//
//    private String accountNumber;
//
//    private float interestRate;
//
//    @Enumerated(EnumType.STRING)
//    private ExpiryDate date;
//
//    @Enumerated(EnumType.STRING)
//    private ProductType type;
}
