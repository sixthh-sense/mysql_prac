package udemy.mysql;

import udemy.mysql.secret.Secret;

import java.sql.*;

/* 20230123
* When gitignore is not working: https://stackoverflow.com/questions/25436312/gitignore-not-working
* (have to delete cache: git rm -rf --cached .)
* also, when u uploaded private info on github by mistake,
* I'll delete commit history instead of deleting the repository itself
* */

public class Main {


    public static void main(String[] args) {

        Secret secret = new Secret();
        // connection with mysql db
        // reference link: https://mdwgti16.github.io/jsp/mysql/#
        // jdbc install reference: https://xzio.tistory.com/1510 (version 8.0.32)
        try {
            Connection conn = DriverManager.getConnection(secret.db_url, secret.db_id, secret.db_pw);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "show databases"
            );

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}