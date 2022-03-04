package com.zzj.eurekaclient.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzj.eurekaclient.pojo.User;

import java.util.List;

/**
 * @author zhaozj37918
 * @date 2022年03月04日 9:57
 */
public interface UserService {
    User queryById(Integer id);

    User queryByName(String name);

    List<User> queryAll();

    IPage<User> queryAllByPage();

    void add(User user);

    void del(Integer id);

    void edit(User user);

}
