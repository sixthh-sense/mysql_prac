package udemy.mysql.jdbc;

import udemy.mysql.secret.Secret;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCustomer {

    static Secret secret = new Secret();
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/db_practice";
        Connection con = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
            return;
        }
        // change SQL dialect?
        String createString = "CREATE TABLE customer " +
                "(customer_id char(6) not null primary key, " +
                "customer_name varchar(15) not null, " +
                "customer_tel varchar(13), " +
                "customer_addr varchar(20))";

        try {
            con = DriverManager.getConnection(url, secret.db_id, secret.db_pw);
            stat = con.createStatement();
            stat.executeUpdate(createString);
            System.out.println("The table customer has been successfully created!");
        } catch(SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            try {
                if (stat != null) stat.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
