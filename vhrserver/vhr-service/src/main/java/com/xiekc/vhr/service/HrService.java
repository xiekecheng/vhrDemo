package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.Hr;
import com.xiekc.vhr.mapper.HrMapper;
import com.xiekc.vhr.utils.HriUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-10-21 20:13
 **/
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr==null){

            throw new UsernameNotFoundException("用户名不存在");
        }

        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HriUtils.getCurrentHr().getId(),keywords);
    }

    public boolean deleteHrById(Integer id) {
        return hrMapper.deleteHrById(id)==1;
    }
}
