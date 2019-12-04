package com.xiekc.vhr.controller.system.basic;

import com.xiekc.vhr.bean.Position;
import com.xiekc.vhr.bean.RespBean;
import com.xiekc.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-07 11:06
 **/
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    /**
     * 查询所有职位
     * @return
     */
    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();

    }

    /**
     * 添加职位
     * @param position
     * @return
     */
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if (positionService.addPosition(position)==1){
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("添加失败");
        }


    }

    /**
     * 修改职位
     * @param position
     * @return
     */
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        // positionService.updatePosition(position);

        if (positionService.updatePosition(position)==1){
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("添加失败");
        }

    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable("id") Integer id){


        if (positionService.deletePos(id)==1){
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }

    }

    @DeleteMapping("/")
    public RespBean deleteBatchPosition( Integer[] id){
        if (positionService.deleteBatchPos(id)==id.length) {
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除成功");
        }

    }



}
