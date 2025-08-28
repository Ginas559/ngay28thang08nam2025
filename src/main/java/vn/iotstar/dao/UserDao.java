package vn.iotstar.dao;

import vn.iotstar.model.User;

public interface UserDao {
    
    /**
     * Lấy thông tin User theo username
     * @param username
     * @return User nếu tồn tại, null nếu không có
     */
    User get(String username);
}
