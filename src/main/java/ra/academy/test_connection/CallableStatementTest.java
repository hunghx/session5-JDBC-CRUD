package ra.academy.test_connection;

import ra.academy.Main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementTest {
    public static void main(String[] args) {

        Connection  conn = Main.getConnection();

        try {
            CallableStatement call = conn.prepareCall("{call proc_update(?,?,?,?,?)}");
            call.setInt(1,2);
            call.setString(2,new Scanner(System.in).nextLine());
            call.setInt(3,new Scanner(System.in).nextInt());
            call.setBoolean(4,new Scanner(System.in).nextBoolean());
            call.setString(5,new Scanner(System.in).nextLine());

            int count = call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
