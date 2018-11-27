package com.guanglian.updateipaddress.repository.impl;

import com.guanglian.updateipaddress.entity.IpAddress;
import com.guanglian.updateipaddress.repository.IpAddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @FileName: IpAddressRepositoryImplTest.java
 * @Package: com.guanglian.updateipaddress.repository.impl
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 11:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IpAddressRepositoryImplTest {

    @Autowired
    private IpAddressRepository ipAddressRepository;

    @Test
    public void save() {
    }

    @Test
    public void update() {
        IpAddress ipAddress = ipAddressRepository.findById(2);
        ipAddress.setProvinceid(new BigDecimal(0));
        ipAddressRepository.update(ipAddress);
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
        IpAddress ipAddress = ipAddressRepository.findById(2);
        if (ipAddress != null) {
            System.out.println(ipAddress.toString());
        }
    }
}