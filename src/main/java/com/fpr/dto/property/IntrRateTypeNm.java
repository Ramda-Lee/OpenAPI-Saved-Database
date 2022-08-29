package com.fpr.dto.property;

import java.io.IOException;

public enum IntrRateTypeNm {
    EMPTY, INTR_RATE_TYPE_NM;

    public String toValue() {
        switch (this) {
            case EMPTY: return "\ub2e8\ub9ac";
            case INTR_RATE_TYPE_NM: return "\ubcf5\ub9ac";
        }
        return null;
    }

    public static IntrRateTypeNm forValue(String value) throws IOException {
        if (value.equals("\ub2e8\ub9ac")) return EMPTY;
        if (value.equals("\ubcf5\ub9ac")) return INTR_RATE_TYPE_NM;
        throw new IOException("Cannot deserialize IntrRateTypeNm");
    }
}
