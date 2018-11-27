package com.guanglian.updateipaddress.base;

import lombok.Data;

@Data
public class TaoBaoIPWithArea {
    /**
     * 0：成功，1：失败
     */
    private int code;
    /**
     * 淘宝返回数据
     */
    private TaoBaoData data;

}