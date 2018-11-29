package com.guanglian.updateipaddress.service.impl;

import com.guanglian.updateipaddress.UpdateipaddressApplicationTests;
import com.guanglian.updateipaddress.service.IpUpdateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @FileName: IpUpdateServiceImplTest.java
 * @Package: com.guanglian.updateipaddress.service.impl
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 11:46
 */
public class IpUpdateServiceImplTest extends UpdateipaddressApplicationTests {

    @Autowired
    private IpUpdateService ipUpdateService;


    @Test
    public void updateIp() throws InterruptedException {
        int i = 15567;
        while (i < 601211) {
            ipUpdateService.updateIp(i);
            Thread.sleep(1000);
            i++;
        }
    }
}