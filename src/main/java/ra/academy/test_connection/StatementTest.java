package ra.academy.test_connection;

import ra.academy.Main;
import ra.academy.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {
    public static void main(String[] args) {
        // Statement dùng để thực thi các câu truy vấn tĩnh
        Connection connect = Main.getConnection();
        // tạo ra 1 đô tượng Statement
        try {
            Statement statement = connect.createStatement();
//            // tạo câu truy vấn
//            ResultSet rs = statement.executeQuery("Select * from student");
//
//            // lấy ra tập kết quả và xử lí nó
//            while(rs.next()){
//                Student s = new Student();
//                s.setId(rs.getInt("id"));
//                s.setName(rs.getString("name"));
//                s.setAge(rs.getInt("age"));
//                s.setAddress(rs.getString("address"));
//                s.setSex(rs.getBoolean("sex"));
//                System.out.println(s);
//            }

            // tấn công sql injection : select * from user where username = 'hunghx' and password ='123456' ;  +'or 1=1'
            int count = statement.executeUpdate("insert into student(name,age,sex,address) value('Nam tx',19,1,'Nghệ An')");
            System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
