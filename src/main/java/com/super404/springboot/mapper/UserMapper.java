package com.super404.springboot.mapper;

import com.super404.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * 访问数据库的接口
 */
public interface UserMapper {

    //推荐使用#{},会被预编译为？,在用值替换；不推荐使用${}，预编译为"xxxx"，存在sql注入风险
    @Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime}, #{age})")
    //获取数据库自增id，keyProperty是JAVA对象的属性，keyColumn表示数据库的字段
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(User user);
}

