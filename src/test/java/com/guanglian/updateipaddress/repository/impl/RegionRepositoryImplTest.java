package com.guanglian.updateipaddress.repository.impl;

import com.guanglian.updateipaddress.UpdateipaddressApplicationTests;
import com.guanglian.updateipaddress.repository.RegionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @FileName: RegionRepositoryImplTest.java
 * @Package: com.guanglian.updateipaddress.repository.impl
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 15:44
 */
public class RegionRepositoryImplTest extends UpdateipaddressApplicationTests {

    @Autowired
    private RegionRepository repository;

    @Test
    public void findByRegionId() {
        String byRegionId = repository.findByRegionId(141123);
        System.out.println(byRegionId);
    }
}