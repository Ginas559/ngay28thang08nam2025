package vn.iotstar.service;

import java.util.List;
import vn.iotstar.model.Category;

public interface CategoryService {
    void insert(Category category); // them moi
    void update(Category category); // cap nhat
    void delete(int id);            // xoa theo id
    Category get(int id);           // lay 1 category
    List<Category> findAll(int userId); // lay tat ca theo user
}
