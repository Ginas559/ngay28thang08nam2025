package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.model.User;
import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM login28_08 WHERE username = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassWord(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ========== Các hàm cho Register ==========
    @Override
    public void insert(User user) {
    	String sql = "INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate) "
    	           + "VALUES (?, ?, ?, ?, ?, 3, ?, ?)";
    	try {
    	    conn = new DBConnection().getConnection();
    	    ps = conn.prepareStatement(sql);
    	    ps.setString(1, user.getEmail());
    	    ps.setString(2, user.getUserName());
    	    ps.setString(3, user.getFullName());
    	    ps.setString(4, user.getPassWord());
    	    ps.setString(5, user.getAvatar());  // có thể null
    	    ps.setString(6, user.getPhone());
    	    ps.setDate(7, new java.sql.Date(user.getCreatedDate().getTime()));
    	    ps.executeUpdate();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }

    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT 1 FROM login28_08 WHERE email = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true; // email đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT 1 FROM login28_08 WHERE username = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true; // username đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT 1 FROM login28_08 WHERE phone = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true; // phone đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
