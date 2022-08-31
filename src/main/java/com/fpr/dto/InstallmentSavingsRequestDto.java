package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class InstallmentSavingsRequestDto {

    private Result result;

    @Getter @Setter
    public class Result {
        private String prdt_div;
        private String total_count;
        private String max_page_no;
        private String now_page_no;
        private String err_cd;
        private String err_msg;
        private List<SavingsRequestDto.BaseList> baseList;
        private List<SavingsRequestDto.OptionList> optionList;
    }

    @Getter @Setter
    public class BaseList {
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
    }

    @Getter @Setter
    public class OptionList {

        private String intr_rate_type;
        private String intr_rate_type_nm;
        private String rsrv_type;
        private String rsrv_type_nm;
        private String save_trm;
        private double intr_rate;
        private double intr_rate2;
    }
}
