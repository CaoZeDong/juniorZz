package com.junior.common.exception;

import com.junior.common.dis.ResultCodeEnum;

/**
 * 403
 *
 * @author wangyiwen
 * @version 1.0 Created in 2019-10-28 17:17
 */
public class AuthorizationException extends BussException {
    public AuthorizationException(ResultCodeEnum resultCode) {
        super(resultCode);
    }

    public AuthorizationException(int code) {
        super(code);
    }
}
