package com.xiekc.vhr.controller.system.hr;

import com.xiekc.vhr.bean.Hr;
import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.service.HrService;
import com.xiekc.vhr.utils.HriUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: Hr
 * @author: Kecheng Xie
 * @since: 2019-11-13 12:02
 **/
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrService.getAllHrs(keywords);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable("id") Integer id){
        if (hrService.deleteHrById(id)){
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }


    }
}
