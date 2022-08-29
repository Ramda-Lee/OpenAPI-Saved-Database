package com.fpr.domain;


import com.fpr.dto.property.IntrRateType;
import com.fpr.dto.property.IntrRateTypeNm;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingsProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sproductId")
    private Long id;

    private String dcls_month;
    private String fin_co_no;
    private String fin_prdt_cd;
    private String kor_co_nm;
    private String fin_prdt_nm;
    private String join_way;
    private String mtrt_int;
    private String spcl_cnd;
    private String join_deny;
    private String join_member;
    private String etc_note;
    private Long max_limit;
    private String dcls_strt_day;
    private String dcls_end_day;
    private String fin_co_subm_day;

    private IntrRateType intr_rate_type;
    private IntrRateTypeNm intr_rate_type_nm;
    private String save_trm;
    private double intr_rate;
    private double intr_rate2;


}
