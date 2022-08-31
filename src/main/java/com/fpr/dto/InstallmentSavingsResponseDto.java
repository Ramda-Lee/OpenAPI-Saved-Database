package com.fpr.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class InstallmentSavingsResponseDto<T> {

    private Result result;
    int status;
    T data;

    public InstallmentSavingsResponseDto(T value, T i) {
    }

    @Getter @Setter
    public class Result {
        @Column(name = "prdt_div")
        private String prdtDiv;
        @Column(name = "total_coun")
        private String totalCount;
        @Column(name = "max_page_no")
        private String maxPageNo;
        @Column(name = "now_page_no")
        private String nowPageNo;
        @Column(name = "err_cd")
        private String errCd;
        @Column(name = "err_msg")
        private String errMsg;
        private List<SavingsRequestDto.BaseList> baseList;
        private List<SavingsRequestDto.OptionList> optionList;
    }

    @Getter @Setter
    public static class BaseList {

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

//        private String dcls_month;
//        private String fin_co_no;
//        private String fin_prdt_cd;
//        private String kor_co_nm;
//        private String fin_prdt_nm;
//        private String join_way;
//        private String mtrt_int;
//        private String spcl_cnd;
//        private String join_deny;
//        private String join_member;
//        private String etc_note;
//        private Long max_limit;
//        private String dcls_strt_day;
//        private String dcls_end_day;
//        private String fin_co_subm_day;
    }

    @Getter @Setter
    public static class OptionList {

        @Column(name = "intr_rate_type")
        private String intrRateType;
        @Column(name = "intr_rate_type_nm")
        private String intrRateTypeNm;
        @Column(name = "rsrv_type")
        private String rsrvType;
        @Column(name = "rsrv_type_nm")
        private String rsrvTypeNm;
        @Column(name = "save_trm")
        private String saveTrm;
        @Column(name = "intr_rate")
        private double intrRate;
        @Column(name = "intr_rate2")
        private double intrRate2;


//        private String intr_rate_type;
//        private String intr_rate_type_nm;
//        private String rsrv_type;
//        private String rsrv_type_nm;
//        private String save_trm;
//        private double intr_rate;
//        private double intr_rate2;
    }
}
