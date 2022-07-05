package com.vip.controller;

import com.vip.pojo.User;
import com.vip.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public Result add(@RequestBody User user){

        Boolean flag = userService.add(user);
        Integer code=flag?Code.ADD_OK:Code.ADD_ERR;
        String msg=flag?"添加成功":"添加失败";
        return new Result(code,flag,msg);
    }
    @DeleteMapping("/{uid}")
    public Result delectByuid(@PathVariable Integer uid){
        Boolean flag = userService.deleteByuid(uid);
        Integer code=flag?Code.DELETE_OK:Code.DELETE_ERR;
        String msg=flag?"删除成功":"删除失败";
        return new Result(code,flag,msg);
    }
    @PutMapping
    public Result update(@RequestBody User user){
        Boolean flag = userService.update(user);
        System.out.println(user);
        Integer code=flag?Code.UPDATE_OK:Code.UPDATE_ERR;
        String msg =flag?"修改成功":"修改失败";
        return new Result(code,flag,msg);
    }

    @GetMapping
    public Result selectAll(){
        List<User> users = userService.selectAll();
        Integer code=(users!=null?Code.SELECT_OK:Code.SELECT_ERR);
        String msg=(users!=null?"":"您查询的结果为空！");
        return  new Result(code,users,msg);
    }
    @GetMapping("/{uid}")
    public Result selectByuid(@PathVariable Integer uid){
        User user = userService.selectByuid(uid);
        Integer code =user!=null?Code.SELECT_OK:Code.SELECT_ERR;
        String msg=(user!=null?"":"您查询的结果为空！");
        return new Result(code,user,msg);
    }

    @GetMapping("/search/{name}")
    public Result select(@PathVariable String name) {
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(name);
        List<User> users = userService.selectLike(name);
        Integer code=(users!=null?Code.SELECT_OK:Code.SELECT_ERR);
        String msg=(users!=null?"":"您查询的结果为空！");
        return new Result(code,users,msg);
    }

}
