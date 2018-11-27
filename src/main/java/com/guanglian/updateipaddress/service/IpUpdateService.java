package com.guanglian.updateipaddress.service;
/**
 * @FileName: IpUpdateService.java
 * @Package: com.guanglian.updateipaddress.service
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 11:18
 */

import com.guanglian.updateipaddress.base.ServiceResponse;
import com.guanglian.updateipaddress.entity.IpAddress;
import org.springframework.stereotype.Service;

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
public interface IpUpdateService {
    ServiceResponse updateIp(Integer id) throws InterruptedException;
}