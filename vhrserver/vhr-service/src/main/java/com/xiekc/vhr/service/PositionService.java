package com.xiekc.vhr.service;

import com.xiekc.vhr.bean.Position;
import com.xiekc.vhr.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-07 11:08
 **/
@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions(){
        return positionMapper.getAllPos();
    }

    public Integer addPosition(Position position) {
        return positionMapper.addPos(position);

    }

    public Integer updatePosition(Position position) {
        return positionMapper.updatePosById(position);
    }

    public Integer deletePos(Integer id){
        return positionMapper.deletePos(id);
    }

    public Integer deleteBatchPos(Integer[] ids){
        return positionMapper.deletePosById(ids);
    }
}
