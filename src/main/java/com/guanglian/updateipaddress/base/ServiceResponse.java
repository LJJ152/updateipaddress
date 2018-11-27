package com.guanglian.updateipaddress.base;/**
 * @FileName: ServiceResponse.java
 * @Package: com.guanglian.updateipaddress.base
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 11:21
 */

import lombok.Data;

/**
 * <p></p>
 * <p/>
 * <PRE>
 * <BR> 修改记录
 * <BR>-----------------------------------------------
 * <BR> 修改日期 修改人 修改内容
 * </PRE>
 *
 * @author lijiajun
 */
@Data
public class ServiceResponse<T> {

    private Integer code;

    private T data;

    private String message;

    public ServiceResponse(Integer code) {
        this.code = code;
    }

    public ServiceResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceResponse(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> ServiceResponse<T> success(){
        return new ServiceResponse<>(0);
    }

    public static <T> ServiceResponse<T> failer(){
        return new ServiceResponse<>(1);
    }
}