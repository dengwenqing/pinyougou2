package com._360dwq.vo;

import java.io.Serializable;

/**
 * @Author Dw_Qin
 * @Date 2017/08/29 16:47
 * @Email 569806951@qq.com
 */
public class Result implements Serializable {
    private Boolean success;
    private String message;

    public Result() {
    }

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static Result okay(String msg){
        return new Result(true,msg);
    }

    public static Result fail(String msg){
        return new Result(false,msg);
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
}
