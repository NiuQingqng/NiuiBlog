package ltd.niui.dao;

import ltd.niui.entity.Category;

import java.util.List;

public interface ICategoryDao {
    //查找所有
    List<Category> findAll();
    //根据id查找
    Category findCategoryById(Integer id);
    //保存
    void saveCategory(Category category);
    //修改
    void updateCategory(Category category);
    //删除
    void deleteCategory(Integer id);
}
