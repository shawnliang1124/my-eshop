package com.shawnliang.eshop.common;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/6
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {


    private Integer errorCode = 0;

    private String errorStr;

    private T results;

    public ApiResponse(Integer errorCode, T results) {
        this.errorCode = errorCode;
        this.results = results;
    }

    public ApiResponse(T results) {
        this.results = results;
    }

}
