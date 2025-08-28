package vn.iotstar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private final String serverName = "localhost";
    private final String dbName = "ltwct5st7"; 
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa"; 
    private final String password = "123456"; 

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
            Connection conn = new DBConnection().getConnection();
            Statement stmt = conn.createStatement();
            
            // Thêm dữ liệu vào bảng login28_08
            stmt.executeUpdate("INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate) "
                    + "VALUES ('trungnh@gmail.com', 'trungAdmin', 'Nguyen Huu Trung', '123', NULL, 1, '0908617108', '2025-08-28')");
            stmt.executeUpdate("INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate) "
                    + "VALUES ('trungnh@gmail.com', 'trungManager', 'Nguyen Huu Trung Assistant', '123', NULL, 2, '0908617109', '2025-08-28')");
            stmt.executeUpdate("INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate) "
                    + "VALUES ('trungnh@gmail.com', 'trungUser', 'Nguyen Huu Trung Assistant', '123', NULL, 3, '0908617109', '2025-08-28')");

            // Lấy dữ liệu từ bảng login28_08
            ResultSet rs = stmt.executeQuery("SELECT * FROM login28_08");
            System.out.println("\nDu lieu tu bang login28_08:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("username") 
                        + " " + rs.getString("fullname") + " " + rs.getString("password")
                        + " " + rs.getInt("roleid") + " " + rs.getString("phone")
                        + " " + rs.getDate("createdDate"));
            }

            conn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
