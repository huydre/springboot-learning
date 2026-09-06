package com.andrewbui.identityservice.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNCATEGORIZED_EXCECPTION(999, "Uncategorize error", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1000, "User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1001, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1002, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    USERNAME_INVALID(1003, "Usernames must be at least 3 characters", HttpStatus.BAD_REQUEST),
    USER_INVALID(1004, "User not found", HttpStatus.BAD_REQUEST),
    KEY_INVALID(1005, "Key not found", HttpStatus.NOT_FOUND),
    PASSWORD_INVALID(1006, "Password must be at least 8 characters", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST);
    ;
    int code;
    String messgae;
    HttpStatusCode statusCode;

    ErrorCode(int code, String messgae, HttpStatusCode statusCode) {
        this.code = code;
        this.messgae = messgae;
        this.statusCode = statusCode;
    }
}
