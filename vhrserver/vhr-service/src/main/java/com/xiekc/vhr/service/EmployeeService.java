package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.*;
import com.xiekc.vhr.mapper.EmpMapper;
import com.xiekc.vhr.mapper.PoliticsStatusMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-14 18:46
 **/
@Service
public class EmployeeService {
    public final static Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    EmpMapper empMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    PoliticsStatusMapper politicsStatusMapper;

    public RespPageBean getEmployeeByPage(Integer page, Integer size) {
        if (page!=null&&size!=null){
            page=(page-1)*size;
        }

        // List<Employee> data = empMapper.getEmployeeByPageShort(page,size);
        List<Employee> data = empMapper.getEmployeeByPageSize(page,size);
        Long total = empMapper.getTotal();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    public RespPageBean getEmployeeByEmpName(Integer page, Integer size, String name) {
        if (page!=null&&size!=null){
            page=(page-1)*size;
        }

        List<Employee> data = empMapper.getEmployeeByEmpName(page, size, name);
        Long total = empMapper.getTotalEmpName(name);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;

    }

    public RespBean addEmployee(Employee employee) {
        if (empMapper.addEmp(employee)==1){
            //向消息队列发送员工信息
            Employee employee1 = empMapper.getEmployeeById(employee.getId());
            LOGGER.info(employee1.toString());
            rabbitTemplate.convertAndSend("xiekc.mail.welcome",employee1);
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("添加失败");
        }

    }

    public List<PoliticsStatus> getPoliticsStatus() {
        return politicsStatusMapper.getPoliticsStatus();
    }

    public List<Nation> getNations() {
        return politicsStatusMapper.getNations();
    }


    public RespBean getMaxWorkId() {
        return RespBean.build().setStatus(200).setObj(String.format("%08d",politicsStatusMapper.getMaxWorkId()+1));
    }

    public RespBean deleteById(String[] ids) {
        if (empMapper.deleteEmpById(ids)==ids.length){
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }
    }

    public Integer addEmployeeList(List<Employee> list) {
        return empMapper.addEmps(list);
    }

    public RespPageBean getEmpByConditionSearch(Integer page, Integer size, Employee employee, String[] beginDateScope) {
        if (page!=null&&size!=null){
            page=(page-1)*size;
        }

        //获取员工信息列表
        List<Employee> data = empMapper.getEmpByConditionSearch(page,size,employee,beginDateScope);

        //获取查询的信息总数
        Long total = empMapper.getTotal2(employee,beginDateScope);


        // List<Employee> data = empMapper.getEmployeeByEmpName(page, size, name);
        // Long total = empMapper.getTotal2(employee,beginDataScope);


        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;




        // return empMapper.getEmpByConditionSearch(page, size, employee, beginDateScope);
    }

    public Integer updateEmployee(Employee employee) {
        return empMapper.updateEmp(employee);

    }
}
