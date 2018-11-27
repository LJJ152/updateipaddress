package com.guanglian.updateipaddress.entity;
/**
 * @FileName: IpAddress.java
 * @Package: com.guanglian.updateip.entity
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 9:06
 */


import lombok.Data;

import java.math.BigDecimal;

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
public class IpAddress {

    private Integer id;

    private String ipstart;

    private String ipend;

    private BigDecimal ipstartnum;

    private BigDecimal ipendnum;

    private String provincename;

    private String cityname;

    private BigDecimal provinceid;

    private BigDecimal cityid;

    private BigDecimal ischina;

    @Override
    public String toString() {
        return "IpAddress{" +
                "id=" + id +
                ", ipstart='" + ipstart + '\'' +
                ", ipend='" + ipend + '\'' +
                ", ipstartnum=" + ipstartnum +
                ", ipendnum=" + ipendnum +
                ", provincename='" + provincename + '\'' +
                ", cityname='" + cityname + '\'' +
                ", provinceid=" + provinceid +
                ", cityid=" + cityid +
                ", ischina=" + ischina +
                '}';
    }
}