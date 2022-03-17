package com.zzj.eurekaclient.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzj.eurekaclient.pojo.User;
import com.zzj.eurekaclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhaozj37918
 * @date 2022年03月03日 17:32
 */
@RestController
public class EurekaClientController {
    @Autowired
    private UserService userService;
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "zzj") String name) {
        return "hi" + name + ",i am from port:" + port;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public User queryById(@RequestParam(value = "id") Integer id) {
        return userService.queryById(id);
    }

    @RequestMapping(value = "/queryByName")
    @ResponseBody
    public User queryByName(@RequestParam(value = "name") String name) {
        return userService.queryByName(name);
    }

    @RequestMapping(value = "/queryAll")
    @ResponseBody
    public List<User> queryAll() {
        return userService.queryAll();
    }

    @RequestMapping(value = "/queryAllByPage")
    @ResponseBody
    public IPage<User> queryAllByPage() {
        return userService.queryAllByPage();
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(@RequestBody User user) {
        userService.add(user);
        return "签约成功";
    }

    @RequestMapping(value = "/del")
    public String del(@RequestParam Integer id) {
        userService.del(id);
        return "删除成功";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestBody User user) {
        userService.edit(user);
        return "修改成功";
    }
}
