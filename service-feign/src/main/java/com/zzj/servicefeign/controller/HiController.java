package com.zzj.servicefeign.controller;

import com.zzj.servicefeign.dto.UserDTO;
import com.zzj.servicefeign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaozj37918
 * @date 2022年03月03日 18:49
 */
@RestController
public class HiController {
    @Autowired(required = false)
    private SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }
    @GetMapping(value = "/queryById")
    @ResponseBody
    public UserDTO queryById(@RequestParam Integer id) {
        return schedualServiceHi.queryById(id);
    }
    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestBody UserDTO userDTO) {
        return schedualServiceHi.add(userDTO);
    }
    @GetMapping(value = "/del")
    @ResponseBody
    public String del(@RequestParam Integer id) {
        return schedualServiceHi.del(id);
    }
    @GetMapping(value = "/edit")
    @ResponseBody
    public String edit(@RequestBody UserDTO userDTO) {
        return schedualServiceHi.edit(userDTO);
    }
}
