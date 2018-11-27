package com.guanglian.updateipaddress.repository.impl;/**
 * @FileName: RegionRepositoryImpl.java
 * @Package: com.guanglian.updateipaddress.repository.impl
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 15:29
 */

import com.guanglian.updateipaddress.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
public class RegionRepositoryImpl implements RegionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findByRegionId(Integer id) {
        String sql = "select name from sys_region where region_id=" +id;
        String str = jdbcTemplate.queryForObject(sql, String.class);
        return str;
    }
}