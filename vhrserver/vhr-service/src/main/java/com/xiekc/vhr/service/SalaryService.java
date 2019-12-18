package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.bean.Salary;
import com.xiekc.vhr.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jnlp.ServiceManager;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-12-04 20:35
 **/
@Service
@Transactional
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalary() {
        return salaryMapper.getAllSalary();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.addSalary(salary);
    }

    public Integer deleteSalaryById(int id) {
        return salaryMapper.deleteSalaryById(id);
    }

    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }
}
