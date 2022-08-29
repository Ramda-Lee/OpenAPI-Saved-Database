package com.fpr.dto.property;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SavingsResult {
    private String prdt_div;
    private String total_count;
    private String max_page_no;
    private String now_page_no;
    private String err_cd;
    private String err_msg;
    private List<SavingsBaseList> savingsBaseList;
    private List<SavingsOptionList> savingsOptionList;
}
