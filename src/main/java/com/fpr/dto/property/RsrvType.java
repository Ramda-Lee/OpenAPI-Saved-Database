package com.fpr.dto.property;

import java.io.IOException;

public enum RsrvType {
    F, S;

    public String toValue() {
        switch (this) {
            case F: return "F";
            case S: return "S";
        }
        return null;
    }

    public static RsrvType forValue(String value) throws IOException {
        if (value.equals("F")) return F;
        if (value.equals("S")) return S;
        throw new IOException("Cannot deserialize RsrvType");
    }
}
