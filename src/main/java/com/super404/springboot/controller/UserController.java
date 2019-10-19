package com.super404.springboot.controller;

import com.super404.springboot.domain.JsonData;
import com.super404.springboot.domain.User;
import com.super404.springboot.mapper.UserMapper;
import com.super404.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * user保存接口
     *
     * @return
     */
    @GetMapping("add")
    public Object add(){

        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("super404");
        user.setPhone("1111111");
        int id = userService.add(user);

        return JsonData.buildSuccess(id);

    }

    @Autowired
    private UserMapper userMapper;

    /**
     * 查找全部用户
     * @return
     */
    @GetMapping("findAll")
    public Object findAll(){
        return  JsonData.buildSuccess(userMapper.getAll());
    }


    @GetMapping("find_by_id")
    public Object findById(long id){
        return JsonData.buildSuccess(userMapper.findById(id));
    }

    @GetMapping("del_by_id")
    public Object delById(long id){
        userMapper.delete(id);
        return JsonData.buildSuccess();
    }

    @GetMapping("update")
    public Object update(String name,int id){
        User user = new User();
        user.setName(name);
        user.setId(id);
        userMapper.update(user);
        return JsonData.buildSuccess();
    }

}
