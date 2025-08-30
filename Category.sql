-- Tạo bảng Category
CREATE TABLE Category (
    cate_id INT IDENTITY(1,1) PRIMARY KEY,     -- khoa chinh tu dong tang
    cate_name NVARCHAR(255) NOT NULL,          -- ten category
    icons NVARCHAR(100) NULL,                  -- bieu tuong
    user_id INT NOT NULL,                      -- lien ket user
    CONSTRAINT FK_Category_User FOREIGN KEY (user_id) REFERENCES login28_08(id)
);

-- Test chèn dữ liệu (thay 3 bằng id user thật trong bảng login28_08)
INSERT INTO Category (cate_name, icons, user_id)
VALUES (N'Thể thao', 'icon-sport', 3),
       (N'Âm nhạc', 'icon-music', 3);
