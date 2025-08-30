package vn.iotstar.service;

import vn.iotstar.model.User;

public interface UserService {
    
    // Hàm đăng nhập (Ví dụ 1)
    User login(String username, String password);

    // Lấy thông tin user theo username (Ví dụ 1)
    User get(String username);

    // ==== Các hàm cho Register (Ví dụ 2) ====
    
    // Thêm mới user
    void insert(User user);

    // Đăng ký user mới
    boolean register(String email, String password, String username, String fullname, String phone);

    // Kiểm tra email đã tồn tại chưa
    boolean checkExistEmail(String email);

    // Kiểm tra username đã tồn tại chưa
    boolean checkExistUsername(String username);

    // Kiểm tra phone đã tồn tại chưa
    boolean checkExistPhone(String phone);
}
