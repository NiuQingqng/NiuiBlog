package ltd.niui.service;

import ltd.niui.entity.Category;

import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:23
 * @description：TODO
 */
public interface ICategoryService {
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
