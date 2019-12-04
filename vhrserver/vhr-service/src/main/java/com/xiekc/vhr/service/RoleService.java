package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.Role;
import com.xiekc.vhr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-09 22:23
 **/
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public int addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.addRole(role);
    }

    public int deleteRole(Integer id) {
        return roleMapper.deleteRoleById(id);
    }
}
