package udemy.mysql.jdbc.insert;

import udemy.mysql.jdbc.domain.Account;
import udemy.mysql.secret.Secret;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoAccount {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        Secret secret = new Secret();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: " + e.getMessage());
            return;
        }

        try {
            con = DriverManager.getConnection(secret.url_db_practice, secret.db_id, secret.db_pw);
            stmt = con.createStatement();

            int rowCount = getNoOfRowToInsert();
            for (int cnt = 0; cnt < rowCount; cnt++) {
                System.out.println((cnt + 1) + "행의 정보를 입력하세요 ==========");
                InputAccount inputAccount = new InputAccount();
                Account account = new Account();
                inputAccount.inputAccountInfo(account);

                String insertString = "INSERT INTO account VALUES " + "('" +
                        account.getAccount_number() + "', '" + account.getCustomerId() +
                        "', '" + account.getBalance() + "')";
                stmt.executeUpdate(insertString);
            }
            System.out.println("====================");
            System.out.println("총 " + rowCount + "개의 레코드가 " +
                    "account 테이블에 삽입되었습니다.");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static int getNoOfRowToInsert() {
        int rowCount = 0;
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("삽입할 행(레코드)의 개수를 입력하세요! : ");

        while (true) {
            try {
                rowCount = Integer.parseInt(dis.readLine());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (rowCount > 0) break;
            System.out.println("1이상의 정수를 입력하십시오! : ");
        }
        return rowCount;
    }
}
