package com.guanglian.updateipaddress.repository;

import com.guanglian.updateipaddress.entity.IpAddress;

/**
 * @FileName: IpAddressRepository.java
 * @Package: com.guanglian.updateipaddress.repository
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 10:35
 */
public interface IpAddressRepository{

    int save(IpAddress ipAddress);
    int update(IpAddress ipAddress);
    int delete(Integer id);
    IpAddress findById(Integer id);
}
