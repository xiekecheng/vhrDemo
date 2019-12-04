package com.xiekc.vhr.mapper;

import com.xiekc.vhr.bean.Nation;
import com.xiekc.vhr.bean.PoliticsStatus;
import com.xiekc.vhr.bean.RespBean;

import java.util.List;

/**
 * @description:
 * @author: xiekecheng
 * @since: 2019-11-18 15:23
 **/
public interface PoliticsStatusMapper {

    List<PoliticsStatus> getPoliticsStatus();
    List<Nation> getNations();

    Long getMaxWorkId();
}
