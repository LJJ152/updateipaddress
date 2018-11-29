package com.guanglian.updateipaddress.web.controller;
/**
 * @FileName: IpdateController.java
 * @Package: com.guanglian.updateipaddress.web.controller
 * @Author: lijiajun
 * <br/>
 * @Created: 2018/11/27 11:19
 */

import com.guanglian.updateipaddress.service.IpUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
public class IpdateController {

    @Autowired
    private IpUpdateService updateService;

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id) throws Exception{
        //最后一位601211
        int i = id;
        while (i > 0) {
            updateService.updateIp(i);
            Thread.sleep(1000);
            i--;
        }
        return "正在更新";
    }

}