package com.xiekc.vhr.controller;

import com.xiekc.vhr.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-10-25 11:10
 **/
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录,请登录!");
    }
}
