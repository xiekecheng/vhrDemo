package com.xiekc.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import com.xiekc.vhr.bean.Department;

import java.util.List;

/**
 * Created by sang on 2018/1/7.
 */
public interface DepartmentMapper {
    void addDep(@Param("dep") Department department);

    void deleteDep(@Param("dep") Department department);

    List<Department> getDepByPid(Integer pid);

    List<Department> getAllDeps();

    boolean selectParent(Integer id);

    int deleteDepById(Integer id);

    Integer selectParentIdById(Integer id);

    Integer updateIsparent(Integer parentId);

    int selectChildrenDeptNum(Integer parentId);
}
