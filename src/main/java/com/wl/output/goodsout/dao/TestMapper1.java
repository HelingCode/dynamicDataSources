package com.wl.output.goodsout.dao;


import com.wl.output.goodsout.config.TargetDataSource;
import com.wl.output.goodsout.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper1 {

    // 查询用户
    @Select(" SELECT * FROM tbl_user")
    @TargetDataSource("db1")
    List<User> getAll();
}