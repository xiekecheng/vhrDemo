package com.xiekc.vhr;

import com.xiekc.vhr.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VhrApplicationTests {

    @Autowired
    MenuService menuService;

    @Test
    void contextLoads() {
        menuService.getMenusByHrId();

    }

}
