package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.model.Category;

public interface CategoryDao {
    void insert(Category category);        // them moi
    void update(Category category);        // cap nhat
    void delete(int id);                   // xoa
    Category get(int id);                  // lay theo id
    List<Category> findAll(int userId);    // lay tat ca theo user
}
