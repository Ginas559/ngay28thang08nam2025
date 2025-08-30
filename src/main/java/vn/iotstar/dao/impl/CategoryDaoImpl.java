package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.model.Category;

public class CategoryDaoImpl implements CategoryDao {
    Connection conn = null;   // ket noi db
    PreparedStatement ps = null; // cau lenh sql
    ResultSet rs = null;     // ket qua truy van

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Category (cate_name, icons, user_id) VALUES (?, ?, ?)";
        try {
            conn = new DBConnection().getConnection(); // mo ket noi
            ps = conn.prepareStatement(sql);           // chuan bi cau lenh
            ps.setString(1, category.getName());       // set cate_name
            ps.setString(2, category.getIcon());       // set icons
            ps.setInt(3, category.getUserId());        // set user_id
            ps.executeUpdate();                        // thuc thi insert
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE Category SET cate_name = ?, icons = ? WHERE cate_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getIcon());
            ps.setInt(3, category.getId());
            ps.executeUpdate(); // thuc thi update
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE cate_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate(); // thuc thi delete
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM Category WHERE cate_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery(); // lay du lieu theo id
            while (rs.next()) {
                return new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getString("icons"),
                        rs.getInt("user_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // khong tim thay
    }

    @Override
    public List<Category> findAll(int userId) {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category WHERE user_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getString("icons"),
                        rs.getInt("user_id")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // tra ve danh sach category cua user
    }
}
