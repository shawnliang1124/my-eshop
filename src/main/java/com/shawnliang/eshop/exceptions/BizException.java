package com.shawnliang.eshop.exceptions;

import com.shawnliang.eshop.constants.BizConstant;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/6
 */
@Data
public class BizException extends RuntimeException {

    private Integer code;

    private String msg;

    public BizException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BizException() {

    }

    public BizException(String msg) {
        this.code = BizConstant.COMMON_BIZ_ERROR_CODE;
        this.msg = msg;
    }
}
