package com.xiekc.vhr.controller.salary;

import com.xiekc.vhr.bean.Salary;
import com.xiekc.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
