package vn.iotstar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private final String serverName = "localhost";
    private final String dbName = "ltwct5st7"; // Tên database của bạn
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa"; // UserID của bạn
    private final String password = "123456"; // Password của bạn

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                    + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            // Kết nối đến database 'ltwct5st7'
            Connection conn = new DBConnection().getConnection();
            // Tạo statement
            Statement stmt = conn.createStatement();
            // Thêm dữ liệu vào bảng 'abc'
            stmt.executeUpdate("INSERT INTO abc (id, username, email) "
                    + "VALUES (1, 'Trung', 'trung@example.com')");
            // Lấy dữ liệu từ bảng 'abc'
            ResultSet rs = stmt.executeQuery("SELECT * FROM abc");
            // Hiển thị dữ liệu
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("username") 
                        + " " + rs.getString("email"));
            }
            conn.close(); // Đóng kết nối
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}