package com.xxxx.vo;

public class CommonResp<T> {
    private String code ="0";
    private String msg= "成功";
    private String traceId ;
    private T data;

    public static CommonResp<Object> success(Object o,String traceId){
        CommonResp<Object> commonResp = new CommonResp();
        commonResp.setCode("0");
        commonResp.setMsg("成功");
        commonResp.setTraceId(traceId);
        commonResp.setData(o);
        return commonResp;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
