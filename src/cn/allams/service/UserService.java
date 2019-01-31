package cn.allams.service;

import cn.allams.dao.UserDao;
import cn.allams.domain.User;

public class UserService {
    private UserDao userDao = new UserDao();

    //用户注册方法
    public void regist(User form) throws UserException{
        User user = userDao.findByUsername(form.getUsername());
        if(user != null) throw new UserException("用户名已被创建");

        userDao.add(form);
    }

    //用户登陆方法
    public User login(User form) throws UserException{
        User user = userDao.findByUsername(form.getUsername());
        if(user == null)
            throw new UserException("用户不存在");

        if(!user.getPassword().equals(form.getPassword())){
            throw new UserException("密码错误");
        }

        return user;
    }
}
