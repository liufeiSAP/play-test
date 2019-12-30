package com.user.login.utils;

import static play.mvc.Results.status;

import play.mvc.Result;


/**
 * The type Result utils.
 */
public final class ResultUtils {

    /**
     * prevent new an instance.
     */
    private ResultUtils() {
    }

    /**
     * Failure result.
     *
     * @param errorCode the error code
     * @param msg       the msg
     * @return the result
     */
    public static Result failure(Integer errorCode, String msg) {
        return status(errorCode,
            new JsonContent(new ErrorContent(errorCode,msg).toString())
        );
    }
}

