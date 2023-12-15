package ra.academy.test_connection;

import ra.academy.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementTest {
    // prepareStatement dùng để tạo ra các câu truy vân động
    public static void main(String[] args) {
        System.out.println("Nhập id muốn xóa");
        int id = new Scanner(System.in).nextInt();
        Connection conn = Main.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("insert into student(name,age,sex,address) value(?,?,?,?)");
            // truyên tham số vào
            pre.setString(1,"hunghxxxx");
            pre.setInt(2,30);
            pre.setBoolean(3,true);
            pre.setString(4,"Hà Nội");

            int count =  pre.executeUpdate();

            if (count>0){
                System.out.println("thêm thành công");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
