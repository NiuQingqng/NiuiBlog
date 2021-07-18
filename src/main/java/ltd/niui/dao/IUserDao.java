package ltd.niui.dao;

import ltd.niui.entity.User;

import java.util.List;

public interface IUserDao {
    //查找所有
    List<User> findAll();
    //根据id查找
    User findUserById(Integer id);
    //保存
    void saveUser(User user);
    //修改
    void updateUser(User user);
    //删除
    void deleteUser(Integer id);
}
