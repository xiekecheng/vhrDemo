package com.xiekc.vhr.controller.emp;

import com.xiekc.vhr.bean.*;
import com.xiekc.vhr.service.DepartmentService;
import com.xiekc.vhr.service.EmployeeService;
import com.xiekc.vhr.service.JobLevelService;
import com.xiekc.vhr.service.PositionService;
import com.xiekc.vhr.utils.POIUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-14 18:41
 **/
@RestController
@RequestMapping("/emp/basic")
@Api(tags = "员工数据接口")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    DepartmentService departmentService;






    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size){
        return employeeService.getEmployeeByPage(page,size);

    }
    @ApiOperation(value = "查询员工" , notes = "通过员工名查询员工")
    @GetMapping("/employee")
    public RespPageBean getEmployeeByEmpName(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,String name){
        return employeeService.getEmployeeByEmpName(page,size,name);
    }

    @GetMapping("/complexSearch")
    public RespPageBean getEmpByConditionSearch(Integer page, Integer size, Employee employee, String[] beginDateScope){
        return employeeService.getEmpByConditionSearch(page,size,employee,beginDateScope);

    }


    @PostMapping("/")
    public RespBean addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);

    }
    @GetMapping("/politicsstatus")
    public List<PoliticsStatus> getPoliticsStatus(){
        return employeeService.getPoliticsStatus();
    }

    @GetMapping("/nations")
    public List<Nation> getNations(){
        return employeeService.getNations();
    }

    @GetMapping("/position")
    public List<Position> getPosition(){
        return positionService.getAllPositions();
    }

    @GetMapping("/joblevel")
    public List<JobLevel> getJobLevel(){
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/maxWorkId")
    public RespBean getMaxWorkId(){
        return employeeService.getMaxWorkId();
    }

    @GetMapping("/department")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }

    @DeleteMapping("/")
    public RespBean deleteById(@RequestParam("ids") String[] ids){
        return employeeService.deleteById(ids);
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list = (List<Employee>)employeeService.getEmployeeByEmpName(null, null, null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException{
        // file.transferTo(new File("/Users/xiekc/Documents/test/"+file.getOriginalFilename()));
        System.out.println(file.getOriginalFilename());
        List<Employee> list = POIUtils.excel2Employee(file,employeeService.getNations(),employeeService.getPoliticsStatus(),departmentService.getDepartment(),positionService.getAllPositions(),jobLevelService.getAllJobLevels());
        employeeService.addEmployeeList(list);
        return RespBean.ok("上传成功");
    }

    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employee employee){
        if (employeeService.updateEmployee(employee)==1){
            return RespBean.ok("更新成功");
        }else {
            return RespBean.error("更新失败");
        }

    }



}
