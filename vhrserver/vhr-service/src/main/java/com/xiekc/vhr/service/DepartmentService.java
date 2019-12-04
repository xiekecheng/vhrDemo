package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.Department;
import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.mapper.DepartmentMapper;
import com.xiekc.vhr.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-19 13:02
 **/
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmpMapper empMapper;

    public List<Department> getDepartment() {
        return departmentMapper.getAllDeps();
    }

    public List<Department> getDepartmentByPid(Integer pid){
        return departmentMapper.getDepByPid(pid);
    }

    public void addDept(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
    }

    @Transactional
    public RespBean deleteDept(Integer id) {
        departmentMapper.selectParent(id);
        if (departmentMapper.selectParent(id)){
            return RespBean.error("该部门有子部门,删除失败");
        }
        if (empMapper.selectEmpDept(id)>0){
            return RespBean.error("该部门下有员工,删除失败");
        }
        //查询parentId
        Integer parentId = departmentMapper.selectParentIdById(id);
        //通过id删除部门
        if (departmentMapper.deleteDepById(id)==1){
            //判断parentId对应的部门是否为父部门
            if (departmentMapper.selectChildrenDeptNum(parentId)==0){
                //更新字段,设为0
                departmentMapper.updateIsparent(parentId);

            }
            return  RespBean.ok("删除成功");
        }


        return RespBean.error("删除失败");





    }
}
