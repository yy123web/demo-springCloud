package com.zzj.eurekaclient.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzj.eurekaclient.dao.UserDao;
import com.zzj.eurekaclient.pojo.User;
import com.zzj.eurekaclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaozj37918
 * @date 2022年03月04日 9:59
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public User queryById(Integer id) {
        User user = userDao.selectById(id);
        return user;
    }

    @Override
    public User queryByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getName,name);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public List<User> queryAll() {

        return userDao.selectList(null);
    }

    @Override
    public IPage<User> queryAllByPage() {
        Page<User> page = new Page<User>(2,6);
        return userDao.selectPage(page,null);
    }

    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    @Override
    public void del(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void edit(User user) {
        userDao.updateById(user);
    }
}
