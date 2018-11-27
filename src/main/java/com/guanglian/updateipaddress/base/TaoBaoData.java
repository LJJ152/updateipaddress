package com.guanglian.updateipaddress.base;

import lombok.Data;

@Data
public class TaoBaoData {
    private String ip;
    /**
     * 国家
     */
    private String country;
    /**
     * 区域（如华北、华东等）
     */
    private String area;
    /**
     * 省
     */
    private String region;
    /**
     * 市
     */
    private String city;
    /**
     * 县
     */
    private String county;
    /**
     * 运营商
     */
    private String isp;
    /**
     * 国家ID
     */
    private String country_id;
    /**
     * 区域ID
     */
    private String area_id;
    /**
     * 省ID
     */
    private String region_id;
    /**
     * 市ID
     */
    private String city_id;
    /**
     * 县ID
     */
    private String county_id;
    /**
     * 运营商ID
     */
    private String isp_id;

}