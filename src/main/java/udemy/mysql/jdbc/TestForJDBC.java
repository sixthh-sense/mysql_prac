package udemy.mysql.jdbc;

import udemy.mysql.secret.Secret;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class TestForJDBC {
    static Secret secret = new Secret();
    public static void main(String[] args) {
        // String url = ""; // copy jdbc connection string to clipboard
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.jdbc.Driver - deprecated, new driver class = com.mysql.cj.jdbc.Driver
        } catch(ClassNotFoundException e) {
            System.err.println("Class Not Found: " + e.getMessage() + ", " + e.getClass());
        }

        try {
            // perspective: outside database(s) - whole server?
            con = DriverManager.getConnection(secret.db_url, secret.db_id, secret.db_pw);
            System.out.println("Successfully connected to DBMS!");
        } catch(SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.err.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
