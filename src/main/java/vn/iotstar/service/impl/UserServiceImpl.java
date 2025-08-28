package vn.iotstar.service.impl;

import vn.iotstar.model.User;
import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.service.UserService;

public class UserServiceImpl implements UserService {

    // Khởi tạo DAO để làm việc với DB
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        // Lấy user theo username
        User user = this.get(username);

        // Nếu tồn tại user và mật khẩu khớp → trả về user
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }

        // Sai username hoặc password
        return null;
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }
}
