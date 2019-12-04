package com.xiekc.vhr.utils;

import com.xiekc.vhr.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-13 14:05
 **/
public class HriUtils {

    public static Hr getCurrentHr(){
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
