package com.xiekc.vhr.controller.config;

import com.xiekc.vhr.bean.Menu;
import com.xiekc.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-01 20:56
 **/
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenuByHrId(){
        return menuService.getMenusByHrId();

    }

    @GetMapping("/hello2")
    public String hello2(){
        System.out.println("hello");
        return "hello";
    }
}
