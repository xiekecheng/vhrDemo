package com.xiekc.vhr.controller.system.basic;

import com.xiekc.vhr.bean.Department;
import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-21 22:41
 **/
@RestController
@RequestMapping("/sys/dept")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDept(){
        return departmentService.getDepartment();

    }

    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department department){
        departmentService.addDept(department);
        if (department.getResult()==1){
            return RespBean.ok("添加成功",department);
        }else {
            return RespBean.error("添加失败");
        }
    }

    @GetMapping("/pid")
    public List<Department> getAllDeptByPid(){
        return departmentService.getDepartmentByPid(-1);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDept(@PathVariable("id") Integer id){
        return departmentService.deleteDept(id);
    }
}
