package ltd.niui.dao;

import ltd.niui.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryDao {
    //查找所有
    List<Category> findAll();
    //根据id查找
    Category findCategoryById(Integer id);
    //保存
    int saveCategory(Category category);
    //修改
    int updateCategory(Category category);
    //删除
    int deleteCategory(Integer id);
}
