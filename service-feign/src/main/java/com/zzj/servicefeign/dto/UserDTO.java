package com.zzj.servicefeign.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaozj37918
 * @date 2022年03月04日 10:17
 */
@Data
public class UserDTO implements Serializable {
    private Integer id;
    private String name;
    private String password;
}
