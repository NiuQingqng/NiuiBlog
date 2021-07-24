package ltd.niui.service;

import ltd.niui.entity.User;

import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:23
 * @description：TODO
 */
public interface IUserService {
    //查找所有
    List<User> findAll();
    //根据id查找
    User findUserById(Integer id);
    //根据用户名查找
    User findUserByUsername(String username);
    //根据用户名和密码查询
    User findUserByUsernameAndPassword(User user);
    //保存
    void saveUser(User user);
    //修改
    void updateUser(User user);
    //删除
    void deleteUser(Integer id);
}
