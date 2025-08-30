package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.model.Category;
import vn.iotstar.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao cateDao = new CategoryDaoImpl(); // goi toi DAO

    @Override
    public void insert(Category category) {
        cateDao.insert(category); // goi DAO insert
    }

    @Override
    public void update(Category category) {
        cateDao.update(category); // goi DAO update
    }

    @Override
    public void delete(int id) {
        cateDao.delete(id); // goi DAO delete
    }

    @Override
    public Category get(int id) {
        return cateDao.get(id); // goi DAO get
    }

    @Override
    public List<Category> findAll(int userId) {
        return cateDao.findAll(userId); // goi DAO findAll
    }
}
