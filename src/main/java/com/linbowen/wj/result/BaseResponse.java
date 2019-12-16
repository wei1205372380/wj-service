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
    private String message;

    /**
     * 业务数据
     */
    private T data;

    public BaseResponse(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }      

    public BaseResponse() {}

    public static <E> BaseResponse<E> buildSuccess(String message) {
        return new BaseResponse<>(true, message, null);
    }

    public static <E> BaseResponse<E> buildFail(String message) {
        return new BaseResponse<>(false, message, null);
    }

    public static <E> BaseResponse<E> buildSuccess() {
        return new BaseResponse<>(true, null, null);
    }

    public static <E> BaseResponse<E> buildFail() {
        return new BaseResponse<>(false, null, null);
    }

    public static <E> BaseResponse<E> buildSuccess(String message, E data) {
        return new BaseResponse<>(true, message, data);
    }

    public static <E> BaseResponse<E> buildFail(String message, E data) {
        return new BaseResponse<>(false, message, data);
    }

    public static <E> BaseResponse<E> buildSuccess(E data) {
        return new BaseResponse<>(true, null, data);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
