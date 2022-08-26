package com.fpr.dto;

import com.fpr.domain.IntrRateType;
import com.fpr.domain.IntrRateTypeNm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {

    private Result result;

    //Result.java
    @Data
    public class Result {
        private String prdtDiv;
        private String totalCount;
        private String maxPageNo;
        private String nowPageNo;
        private String errCD;
        private String errMsg;
        private BaseList[] baseList;
        private OptionList[] optionList;

        // BaseList.java
        @Data
        public class BaseList {
            private String dclsMonth;
            private String finCoNo;
            private String finPrdtCD;
            private String korCoNm;
            private String finPrdtNm;
            private String joinWay;
            private String mtrtInt;
            private String spclCnd;
            private String joinDeny;
            private String joinMember;
            private String etcNote;
            private Long maxLimit;
            private String dclsStrtDay;
            private String dclsEndDay;
            private String finCoSubmDay;
        }

        // OptionList.java
        @Data
        public class OptionList {
            private String dclsMonth;
            private String finCoNo;
            private String finPrdtCD;
            private IntrRateType intrRateType;
            private IntrRateTypeNm intrRateTypeNm;
            private String saveTrm;
            private double intrRate;
            private Double intrRate2;

            }
        }
    }




