package com.xiekc.vhr.controller.system.basic;

import com.xiekc.vhr.bean.JobLevel;
import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-08 17:54
 **/
@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    /**
     * 查询职称
     * @return
     */
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    /**
     * 添加职称
     * @param jobLevel
     * @return
     */
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.addJobLevel(jobLevel)==1){
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("添加失败");
        }
    }

    /**
     * 更新职称
     * @param jobLevel
     * @return
     */
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.updateJobLevel(jobLevel)==1){
            return RespBean.ok("更新成功");
        }else {
            return RespBean.error("更新失败");
        }
    }

    /**
     * 删除职称
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable("id") Integer id){
        if (jobLevelService.deleteJobLevelById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevel( Integer[] ids){
        for (Integer id : ids) {
            System.out.println(id);
        }
        if (jobLevelService.deleteJobLevelByBatch(ids)==ids.length){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }



}
