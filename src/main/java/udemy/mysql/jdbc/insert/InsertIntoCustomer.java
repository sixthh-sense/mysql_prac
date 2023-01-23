package udemy.mysql.jdbc.insert;

import udemy.mysql.secret.Secret;

import java.sql.*;

public class InsertIntoCustomer {
    public static void main(String[] args) {
        Secret secret = new Secret();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
            return;
        }
        int count = 0;

        String insertString = "INSERT INTO customer VALUES ";
        // values는 한번만 명시하고 값을 넣을 수 있지 않나? 일부러 이런 건가?
        String[] recordString = {insertString + "('C-1001', '가나다', '010-1111-2222', '서울')",
                insertString + "('C-1002', '라마바', '010-1111-3333', '부산')",
                insertString + "('C-1003', '사아자', '010-1111-4444', '대구')",
                insertString + "('C-1004', '가나다', '010-1111-5555', '광주')",
                insertString + "('C-1005', '나다라', '010-1111-6666', '대전')",
                insertString + "('C-1006', '다라마', '010-1111-7777', '강원')"};

        try {
            con = DriverManager.getConnection(secret.url_db_practice, secret.db_id, secret.db_pw);
            stmt = con.createStatement();
            while (count < recordString.length) {
                stmt.executeUpdate(recordString[count]);
                count++;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
    }
}
