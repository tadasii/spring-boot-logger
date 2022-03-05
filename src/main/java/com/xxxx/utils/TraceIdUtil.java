package com.xxxx.utils;

import java.util.UUID;

public class TraceIdUtil {
    /**
     * 随机生成 uuid
     * @return
     */
    public static String getTraceId() {
        String traceId = UUID.randomUUID().toString();
        return traceId;
    }
}
