package com.super404.springboot.mapper;

import com.super404.springboot.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserXmlMapper {


    /**
     *
     * 使用@Param注解来声明参数时，如果使用 #{} 或 ${} 的方式都可以，
     * 当你不使用@Param注解来声明参数时，必须使用使用 #{}方式。如果使用 ${} 的方式，会报错。
     *
     * 不使用@Param注解时，参数只能有一个，并且是Javabean。
     * 多个参数，必须使用@Param注解，(@Param("aaaa") String name,@Param("bbbb") Long id)、
     * (@Param("roleP") RoleParam role, @Param("permissionP") PermissionParam permission)以区分。
     * 在SQL语句里可以引用JavaBean的属性，而且只能引用JavaBean的属性。
     *
     * (@Param("user") User user)，关联条件要用#{user.name}等；
     * 不使用@Param("user") (User user)，直接使用#{name}等。
     */


    /**
     * sql写在xml中
     * @return
     */
    List<User> findAll();

    void deleteByXml(Long userId);

    void updateByXml(User user);

    User findByIdByXml(Long id);

    int insertByXml(User user);

    void updateByXmlUseParam(@Param("name") String name, @Param("id") Long id);

}
