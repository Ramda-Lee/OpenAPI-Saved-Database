package com.fpr.dto.property;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
public class InstallmentSavingsOptionList {

    @Enumerated(EnumType.STRING)
    private IntrRateType intr_rate_type;
    @Enumerated(EnumType.STRING)
    private IntrRateTypeNm intr_rate_type_nm;
    @Enumerated(EnumType.STRING)
    private String rsrv_type;
    @Enumerated(EnumType.STRING)
    private String rsrv_type_nm;
    private String save_trm;
    private double intr_rate;
    private double intr_rate2;
}
