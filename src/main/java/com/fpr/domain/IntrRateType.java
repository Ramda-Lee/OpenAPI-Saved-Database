package com.fpr.domain;

import java.io.IOException;

public enum IntrRateType {
    M, S;

    public String toValue() {
        switch (this) {
            case M:
                return "M";
            case S:
                return "S";
        }
        return null;
    }

    public static IntrRateType forValue(String value) throws IOException {
        if (value.equals("M")) return M;
        if (value.equals("S")) return S;
        throw new IOException("Cannot deserialize IntrRateType");
    }
}
