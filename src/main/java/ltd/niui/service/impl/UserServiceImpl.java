package ltd.niui.service.impl;

import ltd.niui.dao.IUserDao;
import ltd.niui.entity.User;
import ltd.niui.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:27
 * @description：TODO
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userDao.findUserById(id);
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        return user;
    }

    @Override
    public User findUserByUsernameAndPassword(User user) {
        return userDao.findUserByUsernameAndPassword(user);
    }

    @Override
    public void saveUser(User user) {
        //判断用户名是否重复
        if(userDao.findUserByUsername(user.getUserName())==null){
            user.setUserRegisterTime(new Date());
            user.setUserLastLoginTime(new Date());
            userDao.saveUser(user);
        }else {

        }
    }
    /*
    * 修改用户信息时根据id查找用户必须存在
    * 然后根据username查找，判断用户名是否重复
    * */
    @Override
    public void updateUser(User user) {
        if(userDao.findUserById(user.getUserId())!=null
                &&userDao.findUserByUsername(user.getUserName())==null){
            userDao.updateUser(user);
        }else {

        }
    }
    /*
     * 根据id判断，用户存在才执行删除
     * */
    @Override
    public void deleteUser(Integer id) {
        if(userDao.findUserById(id)!=null){
            userDao.deleteUser(id);
        }else {

        }
    }
}
