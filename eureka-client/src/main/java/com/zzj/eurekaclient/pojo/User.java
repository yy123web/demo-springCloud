package com.zzj.eurekaclient.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaozj37918
 * @date 2022年03月04日 9:55
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
}
