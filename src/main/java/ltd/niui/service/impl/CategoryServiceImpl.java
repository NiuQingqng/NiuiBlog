package ltd.niui.service.impl;

import ltd.niui.dao.ICategoryDao;
import ltd.niui.entity.Category;
import ltd.niui.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:26
 * @description：TODO
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryDao.findAll();
        return categories;
    }

    @Override
    public Category findCategoryById(Integer id) {
        Category category = categoryDao.findCategoryById(id);
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        categoryDao.saveCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        if(categoryDao.findCategoryById(category.getCategoryId())!=null){
            categoryDao.updateCategory(category);
        }else {

        }
    }

    @Override
    public void deleteCategory(Integer id) {
        if(categoryDao.findCategoryById(id)!=null){
            //需要先对该分类下文章进行处理

            categoryDao.deleteCategory(id);
        }else {

        }
    }
}
