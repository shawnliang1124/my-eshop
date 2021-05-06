package com.shawnliang.eshop.constants.enums;

import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/6
 */
@Getter
@AllArgsConstructor
public enum ErrorEnum {

    /**
     * 异常枚举
     */
    PARAM_EXCEPTION(100901, "参数异常"),

    ;

    private Integer code;

    private String msg;


    public static ErrorEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (ErrorEnum value : ErrorEnum.values()) {
            if (Objects.equals(value.getCode(), code)) {
                return value;
            }
        }

        return null;
    }
}
