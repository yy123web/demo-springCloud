package com.zzj.servicefeign.dto;

import lombok.Data;
import net.sf.oval.constraint.NotBlank;

import java.io.Serializable;

import net.sf.oval.constraint.Length;

/**
 * @author zhaozj37918
 * @date 2022年03月04日 10:17
 */
@Data
public class UserDTO implements Serializable {
    private Integer id;
    @NotBlank(errorCode = "51521", message = "姓名不能为空")
    private String name;
    @NotBlank(message = "密码不能为空")
    @Length(errorCode = "51522", message = "长度不能低于6位", min = 6, max = 120)
    private String password;
}
