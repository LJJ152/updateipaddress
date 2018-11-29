package com.guanglian.updateipaddress.service.impl;/**
 * @FileName: IpUpdateServiceImpl.java
 * @Package: com.guanglian.updateipaddress.service.impl
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 11:20
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guanglian.updateipaddress.base.ServiceResponse;
import com.guanglian.updateipaddress.base.TaoBaoIPWithArea;
import com.guanglian.updateipaddress.entity.IpAddress;
import com.guanglian.updateipaddress.repository.IpAddressRepository;
import com.guanglian.updateipaddress.repository.RegionRepository;
import com.guanglian.updateipaddress.service.IpUpdateService;
import com.guanglian.updateipaddress.utils.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Service
@Slf4j
public class IpUpdateServiceImpl implements IpUpdateService {

    private static int i = 0;

    private static boolean flag = true;


    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private IpAddressRepository ipAddressRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public ServiceResponse updateIp(Integer id) throws InterruptedException {
        //获取到相应的ip实体类
        IpAddress ipAddress = ipAddressRepository.findById(id);
        //如果不为空
        if (ipAddress != null) {
            String url = "http://ip.taobao.com/service/getIpInfo.php" + "?ip=" + ipAddress.getIpstart() + ".0";
            TaoBaoIPWithArea area = findArea(url, id);
            int count = 0;
            //判断是否获取到area，一直重复获取
            while (!flag) {
                Thread.sleep(2000);
                area = findArea(url, id);
                if (area != null){
                    flag = !flag;
                }
            }

            if (count == 3){return  null;}
            //先判断是否是中国的
            if (!area.getData().getCountry().equals("中国")) {
                if ( !area.getData().getCountry().equals(ipAddress.getProvincename())  ) {
                    ipAddress.setProvincename(area.getData().getCountry() );
                    ipAddressRepository.update(ipAddress);
                    log.info("不同国家更新成功，id:" + ipAddress.getId());
                }
                return ServiceResponse.success();
            }
            //如果省不一样 执行
       /*     String region = area.getData().getRegion();
            String region2 = region.substring(0, 2);
            String provincename = ipAddress.getProvincename();
            String provincename2 = provincename.substring(0, 2);
            if ( !region2.equals( provincename2 ) ) {
                ipAddress.setProvincename(area.getData().getRegion() );
                ipAddress.setProvinceid(new BigDecimal( Integer.parseInt (area.getData().getRegion_id() )) );
                ipAddress.setCityname(area.getData().getCity());
                ipAddress.setCityid(new BigDecimal( Integer.parseInt (area.getData().getCity_id())));
                ipAddressRepository.update(ipAddress);
                log.info("省更新成功，id:" + ipAddress.getId());
            }*/

            //如果市不一样 执行
            if (!area.getData().getCity().equalsIgnoreCase("XX") && ipAddress.getCityname() != null ) {
                String city = area.getData().getCity();
                String city2 = city.substring(0, 2);
                String cityname = ipAddress.getCityname();
                String cityname2 = cityname.substring(0, 2);
                if (!city2.equals(cityname2)) {
                    //省id
                    int regionId = Integer.parseInt(area.getData().getRegion_id());
                    //市id
                    int cityId = Integer.parseInt(area.getData().getCity_id());
                    //更新省市及其ID
                    try {
                        ipAddress.setProvincename(regionRepository.findByRegionId(regionId));
                        ipAddress.setProvinceid(new BigDecimal(regionId));
                        ipAddress.setCityname(regionRepository.findByRegionId(cityId));
                        ipAddress.setCityid(new BigDecimal(cityId));
                        ipAddressRepository.update(ipAddress);
                    } catch (Exception e) {
                        log.error("区划表中没有查询到此区域");
                    }

                    log.info("市更新成功，id:" + ipAddress.getId());
                }
            }

        }

        return  ServiceResponse.success();
    }

    public TaoBaoIPWithArea findArea(String url, int id){
        TaoBaoIPWithArea area = null;
        try {
            String areaJson = HttpRequestUtil.httpRequest(url, "GET", null);
            area =  objectMapper.readValue(areaJson,  TaoBaoIPWithArea.class);
            LocalDateTime nowTime = LocalDateTime.now();
            log.info("当前时间："+nowTime.getHour() + ":" + nowTime.getMinute() + ":" + nowTime.getSecond() + ",当前id:" + id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("没有获取到，访问受限制");
            flag = false;
        } finally {
            return area;
        }
    }
}