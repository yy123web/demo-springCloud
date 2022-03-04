package com.zzj.servicefeign.service;

import com.zzj.servicefeign.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
    @RequestMapping(value = "/queryById")
    UserDTO queryById(@RequestParam(value = "id") Integer id);
    @RequestMapping(value = "/add")
    String add(@RequestBody UserDTO userDTO);
    @RequestMapping(value = "/del")
    String del(@RequestParam(value = "id") Integer id);
    @RequestMapping(value = "/edit")
    String edit(@RequestBody UserDTO userDTO);

}
