package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.Hr;
import com.xiekc.vhr.bean.Menu;
import com.xiekc.vhr.bean.Role;
import com.xiekc.vhr.mapper.MenuMapper;
import com.xiekc.vhr.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-01 20:59
 **/
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByHrId(){
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenuTree() {
        return menuMapper.menuTree();
    }

    public List<Integer> getRolesId(Integer id) {
        return menuMapper.getMenusByRid(id);

    }

    @Transactional
    public boolean updateMenu_Role(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteMenuByRid(rid);
        Integer result = menuRoleMapper.addMenu(rid, mids);
        return result==mids.length;


    }

}
