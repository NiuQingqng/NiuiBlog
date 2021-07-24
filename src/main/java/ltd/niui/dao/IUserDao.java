package ltd.niui.dao;

import ltd.niui.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    //查找所有
    List<User> findAll();
    //根据id查找
    User findUserById(Integer id);
    //根据用户名查找
    User findUserByUsername(String username);
    //根据用户名和密码查询
    User findUserByUsernameAndPassword(User user);
    //保存
    int saveUser(User user);
    //修改
    int updateUser(User user);
    //删除
    int deleteUser(Integer id);
}
