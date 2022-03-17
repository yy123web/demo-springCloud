package com.zzj.servicefeign.controller;

import com.zzj.servicefeign.dto.UserDTO;
import com.zzj.servicefeign.service.SchedualServiceHi;
import com.zzj.servicefeign.util.OvalCheckHelper;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import net.sf.oval.constraint.AssertValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zhaozj37918
 * @date 2022年03月03日 18:49
 */
@RestController
@Slf4j
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

    @GetMapping(value = "/signProtocol")
    @ResponseBody
    public String signProtocol(@RequestBody UserDTO userDTO) throws Exception {
        OvalCheckHelper.validate(userDTO);
        try {
            UserDTO user = schedualServiceHi.queryById(userDTO.getId());
            if (user != null) {
                return "协议已签约";
            }
            String result = schedualServiceHi.add(userDTO);
            if ("签约成功".equals(result)) {
                return "签约成功";
            }
            return "签约失败";
        } catch (Exception e) {
            log.info("异常", e);
            throw new Exception("未知异常");
        }
    }


}
