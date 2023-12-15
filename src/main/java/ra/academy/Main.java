package ra.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/jdbc";
    final static String username = "root";
    final static String password = "hung18061999";
    public static void main(String[] args) {
        // phương thức main dùng để bắt đầu chương trình
        // khai báo Driver kết nối tới CSDL mysql


       // thực hiện mở kết nối tới csdl
        Connection conn = getConnection();
        System.out.println(conn);
    }
    public static Connection getConnection(){
        Connection connection= null;
        try {
            Class.forName(DRIVER);// khai báo Driver kết nối Mysql
            // tiến hành mở kết nối
            connection = DriverManager.getConnection(URL,username,password);
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy driver tương thích");
        } catch (SQLException e) {
            System.err.println("Từ chối truy cập CSDL vì lỗi xác thực");
        }
        return connection;
    }
}
