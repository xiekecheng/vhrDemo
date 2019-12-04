package com.xiekc.vhr.controller.system.basic;

import com.xiekc.vhr.bean.Menu;
import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.bean.Role;
import com.xiekc.vhr.service.MenuService;
import com.xiekc.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-09 22:22
 **/
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {
    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menu")
    public List<Menu> getMenuTree(){
        return menuService.getMenuTree();

    }

    @GetMapping("/roles/{id}")
    public List<Integer> getRolesId(@PathVariable("id") Integer id){
        return menuService.getRolesId(id);
    }

    @PutMapping("/")
    public RespBean updateMenu_Role(Integer rid,Integer[] mids){
        if (menuService.updateMenu_Role(rid,mids)){
            return RespBean.ok("修改成功");
        }else {
            return RespBean.error("修改失败");
        }

    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role)==1){
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("添加失败");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRole(@PathVariable("id") Integer id){
        if (roleService.deleteRole(id)==1){
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }

    }

}
