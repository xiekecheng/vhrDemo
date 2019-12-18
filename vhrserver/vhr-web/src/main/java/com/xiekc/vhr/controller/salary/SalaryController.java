package com.xiekc.vhr.controller.salary;

import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.bean.Salary;
import com.xiekc.vhr.service.SalaryService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-12-04 20:34
 **/
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;


    @GetMapping("/")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary){
        if (salaryService.addSalary(salary)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.ok("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable int id){
        if (salaryService.deleteSalaryById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.ok("添加失败");
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary){
        if (salaryService.updateSalary(salary)==1){
            return RespBean.ok("修改成功");
        }
        return RespBean.ok("修改失败");
    }


}
