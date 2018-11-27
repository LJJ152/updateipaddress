package com.guanglian.updateipaddress.repository.impl;
/**
 * @FileName: IpAddressRepositoryImpl.java
 * @Package: com.guanglian.updateipaddress.repository.impl
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 11:02
 */

import com.guanglian.updateipaddress.entity.IpAddress;
import com.guanglian.updateipaddress.repository.IpAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
@Repository
@Transactional
public class IpAddressRepositoryImpl implements IpAddressRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(IpAddress ipAddress) {
        return 0;
    }

    @Override
    public int update(IpAddress ipAddress) {
        return jdbcTemplate.update("UPDATE ipaddress SET provincename = ? , cityname = ? , provinceid = ? , cityid = ? WHERE id=?",
                ipAddress.getProvincename(), ipAddress.getCityname(), ipAddress.getProvinceid(), ipAddress.getCityid(), ipAddress.getId());
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public IpAddress findById(Integer id) {
        IpAddress ipAddress = null;
        try {
            ipAddress = jdbcTemplate.queryForObject("SELECT * FROM ipaddress WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<IpAddress>(IpAddress.class));
        } catch (Exception e) {
            return null;
        }
        return ipAddress;
    }
}