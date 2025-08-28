-- Sử dụng database ltwct5st7
USE ltwct5st7;

-- Tạo bảng login28_08 với cấu trúc như slide (tương ứng User.java)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'login28_08')
CREATE TABLE login28_08 (
    id INT PRIMARY KEY IDENTITY(1,1),
    email VARCHAR(255),
    username VARCHAR(50),
    fullname VARCHAR(100),
    password VARCHAR(255),
    avatar VARCHAR(255),
    roleid INT,
    phone VARCHAR(15),
    createdDate DATE
);

-- Thêm 2 dòng dữ liệu, tái sử dụng thông tin thầy Nguyễn Hữu Trung
INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate)
VALUES ('trungnh@gmail.com', 'trungnh', 'Nguyen Huu Trung', '123456', NULL, 1, '0908617108', '2025-08-28');

INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate)
VALUES ('trungnh@gmail.com', 'trungnh2', 'Nguyen Huu Trung Assistant', '654321', NULL, 2, '0908617109', '2025-08-28');