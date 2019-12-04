package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.JobLevel;
import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-08 17:55
 **/
@Service
public class JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.addJobLevel(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateJobLevel(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteJobById(id);
    }

    public Integer deleteJobLevelByBatch(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelByBatch(ids);
    }
}
