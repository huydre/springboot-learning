package com.andrewbui.identityservice.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCECPTION(400, "Uncategorize error"),
    USER_EXISTED(400, "User existed"),
    USERNAME_INVALID(400, "Usernames must be at least 3 characters"),
    USER_INVALID(400, "User not found"),
    KEY_INVALID(400, "Key not found"),
    PASSWORD_INVALID(400, "Password must be at least 8 characters");
    ;
    private int code;
    private String messgae;

    ErrorCode(int code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }

    public int getCode() {
        return code;
    }

    public String getMessgae() {
        return messgae;
    }
}
