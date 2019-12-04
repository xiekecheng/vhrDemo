package com.xiekc.vhr.mapper;

import com.xiekc.vhr.bean.Menu;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Integer> getMenusByRid(Integer rid);
}
