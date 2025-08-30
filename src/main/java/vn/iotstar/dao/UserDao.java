package vn.iotstar.dao;

import vn.iotstar.model.User;

public interface UserDao {
    
    // Lấy thông tin User theo username
    User get(String username);

    // ========== Các hàm cho Register ==========
    
    // Thêm mới user
    void insert(User user);

    // Kiểm tra email đã tồn tại chưa
    boolean checkExistEmail(String email);

    // Kiểm tra username đã tồn tại chưa
    boolean checkExistUsername(String username);

    // Kiểm tra phone đã tồn tại chưa
    boolean checkExistPhone(String phone);
}
