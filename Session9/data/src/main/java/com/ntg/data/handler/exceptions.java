package com.ntg.data.handler;

import lombok.Setter;

public enum exceptions {

    GeneralException("0000", "Please contact support team."),
    USER_NOT_FOUND("0001", "User not found.");

    exceptions(String code, String error) {
        this.code = code;
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    String code;
    String error;
}
