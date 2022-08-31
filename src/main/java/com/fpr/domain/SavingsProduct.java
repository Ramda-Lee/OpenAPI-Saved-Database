package com.fpr.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingsProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long sProductId;

    @Column(name = "dcls_month")
    private String dclsMonth;
    @Column(name = "fin_co_no")
    private String finCoNo;
    @Column(name = "fin_prdt_cd")
    private String finPrdtCd;
    @Column(name = "kor_co_nm")
    private String korCoNm;
    @Column(name = "fin_prdt_nm")
    private String finPrdtNm;
    @Column(name = "join_way")
    private String joinWay;
    @Column(name = "mtrt_int")
    private String mtrtInt;
    @Column(name = "spcl_cnd")
    private String spclCnd;
    @Column(name = "join_deny")
    private String joinDeny;
    @Column(name = "join_member")
    private String joinMember;
    @Column(name = "etc_note")
    private String etcNote;
    @Column(name = "max_limi")
    private Long maxLimit;
    @Column(name = "dcls_strt_day")
    private String dclsStrtDay;
    @Column(name = "dcls_end_day")
    private String dclsEndDay;
    @Column(name = "fin_co_subm_day")
    private String finCoSubmDay;

    @Column(name = "intr_rate_type")
    private String intrRateType;
    @Column(name = "intr_rate_type_nm")
    private String intrRateTypeNm;
    @Column(name = "save_trm")
    private String saveTrm;
    @Column(name = "intr_rate")
    private double intrRate;
    @Column(name = "intr_rate2")
    private double intrRate2;


}
