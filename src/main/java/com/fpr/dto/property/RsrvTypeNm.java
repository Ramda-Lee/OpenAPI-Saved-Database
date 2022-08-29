package com.fpr.dto.property;

import java.io.IOException;

public enum RsrvTypeNm {
    EMPTY, RSRV_TYPE_NM;

    public String toValue() {
        switch (this) {
            case EMPTY: return "\uc790\uc720\uc801\ub9bd\uc2dd";
            case RSRV_TYPE_NM: return "\uc815\uc561\uc801\ub9bd\uc2dd";
        }
        return null;
    }

    public static RsrvTypeNm forValue(String value) throws IOException {
        if (value.equals("\uc790\uc720\uc801\ub9bd\uc2dd")) return EMPTY;
        if (value.equals("\uc815\uc561\uc801\ub9bd\uc2dd")) return RSRV_TYPE_NM;
        throw new IOException("Cannot deserialize RsrvTypeNm");
    }
}