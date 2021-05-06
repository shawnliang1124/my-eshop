package com.shawnliang.eshop.interceptors;

import com.shawnliang.eshop.common.ApiResponse;
import com.shawnliang.eshop.constants.BizConstant;
import com.shawnliang.eshop.constants.enums.ErrorEnum;
import com.shawnliang.eshop.exceptions.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/6
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    /**
     * 全局异常
     *
     * @param exception .
     *
     * @return .
     */
    @ExceptionHandler({Exception.class})
    public ApiResponse exceptionHandler(Exception exception) {
        log.info("全局异常[ERROR]: {}", exception.getMessage());
        log.error("全局异常: ", exception);
        if (exception instanceof BizException) {
            BizException bizException = (BizException) exception;
            ErrorEnum errorEnum = ErrorEnum.getByCode(bizException.getCode());
            if (errorEnum == null) {
                return new ApiResponse(BizConstant.COMMON_BIZ_ERROR_CODE, "通用业务异常");
            }
            return new ApiResponse(errorEnum.getCode(), errorEnum.getMsg());
        }
        return new ApiResponse(BizConstant.COMMON_ERROR_CODE, "全局异常");
    }

}
