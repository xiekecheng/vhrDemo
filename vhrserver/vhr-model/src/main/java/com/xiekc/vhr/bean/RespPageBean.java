package com.xiekc.vhr.bean;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-14 18:42
 **/
@Data
public class RespPageBean {
    private Long total;
    private List<?> data;
}
