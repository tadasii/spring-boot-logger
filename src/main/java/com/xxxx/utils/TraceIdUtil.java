package com.xxxx.utils;

import java.util.UUID;

public class TraceIdUtil {
    /**
     * éĉşçĉ uuid
     * @return
     */
    public static String getTraceId() {
        String traceId = UUID.randomUUID().toString();
        return traceId;
    }
}
