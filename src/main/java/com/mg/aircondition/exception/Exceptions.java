package com.mg.aircondition.exception;

import org.hibernate.annotations.NotFound;

import static com.mg.aircondition.exception.ErrorMsg.*;

public enum Exceptions {

    POST_USER_DUPLICATION(409, DUPLICATED_ENTRY_REQUEST, "Phone Number is duplicated"),
    POST_USER_INTERNAL_ERROR(500, INTERNAL_ERROR_REQUEST, "can't register with this user"),
    USER_NOT_FOUND_ERROR(404,NOT_FOUND_REQUEST, "Can't find this user with that id"),

    UPDATE_USER_BAD_REQUEST_ERROR(400,BAD_REQUEST, "invalid Json body request");

    public final int code;
    public final String message;
    public final String desc;

    Exceptions(int code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }
}
