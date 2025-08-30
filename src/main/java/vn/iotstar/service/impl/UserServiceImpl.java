package vn.iotstar.service.impl;

import java.sql.Date;

import vn.iotstar.model.User;
import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    // ========== Ví dụ 1: Login ==========
    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    // ========== Ví dụ 2: Register ==========
    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        // Kiểm tra username đã tồn tại chưa
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        // Kiểm tra email đã tồn tại chưa
        if (userDao.checkExistEmail(email)) {
            return false;
        }
        // Kiểm tra phone đã tồn tại chưa
        if (userDao.checkExistPhone(phone)) {
            return false;
        }

        // Nếu chưa tồn tại thì tạo user mới
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        // avatar = null, roleid = 3 (user mặc định), createdDate = hôm nay
        User newUser = new User(email, username, fullname, password, null, 3, phone, date);

        userDao.insert(newUser);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }
}
