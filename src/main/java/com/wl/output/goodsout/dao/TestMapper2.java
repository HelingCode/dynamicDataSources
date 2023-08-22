package com.wl.output.goodsout.dao;


import com.wl.output.goodsout.config.TargetDataSource;
import com.wl.output.goodsout.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper2 {
    @Select(" SELECT * FROM tbl_user")
//    @TargetDataSource("db2")
    List<User> getAll();
}