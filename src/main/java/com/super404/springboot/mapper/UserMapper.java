package com.super404.springboot.mapper;

import com.super404.springboot.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 访问数据库的接口
 */
public interface UserMapper {
    //推荐使用#{},会被预编译为？,在用值替换；不推荐使用${}，预编译为"xxxx"，存在sql注入风险
    @Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime}, #{age})")
    //获取数据库自增id，keyProperty是JAVA对象的属性，keyColumn表示数据库的字段
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(User user);


    /**
     * 查找全部
     * @return
     */
    @Select("SELECT * FROM user")
    //把数据字段映射到对象的属性，多个映射，@Result()用逗号分隔
    @Results(
            id="userMap",
            value = {
            @Result(column = "create_time",property = "createTime")  //javaType = java.util.Date.class
    })
    List<User> getAll();

    /**
     * 根据id找对象
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    User findById(Long id);

    /**
     * 更新对象名称
     * @param user
     */
    @Update("UPDATE user SET name=#{name} WHERE id =#{id}")
    void update(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    @Delete("DELETE FROM user WHERE id =#{userId}")
    void delete(Long userId);


    /**
     * sql写在xml中
     * @return
     */
    List<User> findAll();
}

