package vn.iotstar.service;

import vn.iotstar.model.User;

public interface UserService {
    
    /**
     * Hàm kiểm tra đăng nhập với username và password
     * @param username
     * @param password
     * @return User nếu đăng nhập thành công, null nếu thất bại
     */
    User login(String username, String password);

    /**
     * Lấy thông tin user theo username
     * @param username
     * @return User nếu tìm thấy, null nếu không có
     */
    User get(String username);
}
