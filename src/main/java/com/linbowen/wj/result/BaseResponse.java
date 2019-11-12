package com.linbowen.wj.result;

/**
 * 公共响应类
 */
public class BaseResponse<T> {

    /**
     * 响应状态
     */
    private Boolean success;

    /**
     * 响应提示
     */
    private String msg;

    /**
     * 业务数据
     */
    private T resultInfo;

    public BaseResponse(Boolean success, String msg, T resultInfo) {
        this.success = success;
        this.msg = msg;
        this.resultInfo = resultInfo;
    }

    public BaseResponse() {}

    public static <E> BaseResponse<E> buildSuccess(String msg) {
        return new BaseResponse<>(true, msg, null);
    }

    public static <E> BaseResponse<E> buildFail(String msg) {
        return new BaseResponse<>(false, msg, null);
    }

    public static <E> BaseResponse<E> buildSuccess() {
        return new BaseResponse<>(true, null, null);
    }

    public static <E> BaseResponse<E> buildFail() {
        return new BaseResponse<>(false, null, null);
    }

    public static <E> BaseResponse<E> buildSuccess(String msg, E resultInfo) {
        return new BaseResponse<>(true, msg, resultInfo);
    }

    public static <E> BaseResponse<E> buildFail(String msg, E resultInfo) {
        return new BaseResponse<>(false, msg, resultInfo);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(T resultInfo) {
        this.resultInfo = resultInfo;
    }
}
