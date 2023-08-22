package com.wl.output.goodsout;

import com.wl.output.goodsout.dao.TestMapper1;
import com.wl.output.goodsout.dao.TestMapper2;
import com.wl.output.goodsout.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GoodsOutApplicationTests {

    @Autowired
    private TestMapper1 mapper1;
    @Autowired
    private TestMapper2 mapper2;

    @Test
    public void select1(){
        List<User> all = mapper1.getAll();
        for (User user : all) {
            log.info("###########DB2 " + user.getUsername());
        }
        log.info("##################DB1##################  " + all.size());

    }
    @Test
    public void select2(){
        List<User> all = mapper2.getAll();
        for (User user : all) {
            log.info("###########DB2 " + user.getUsername());
        }
        log.info("##################DB2##################  " + all.size());

    }


}
