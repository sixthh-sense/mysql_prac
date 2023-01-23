package udemy.mysql.jdbc.insert;

import udemy.mysql.jdbc.domain.Account;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputAccount {
    private final BufferedReader dis;
    public InputAccount() {
        dis = new BufferedReader(new InputStreamReader(System.in));
    }

    public void inputAccountInfo(Account account) {
        account.setAccountNumber(inputAccountNumber());
        account.setCustomerId(inputCustomerId());
        account.setBalance(inputBalance());
    }

    public String inputAccountNumber() {
        String account_number = null;
        while (true) {
            System.out.println("계좌번호: ");
            try {
                account_number = dis.readLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (validateNumber(account_number, 'A')) break;
            System.out.print("잘못된 계좌번호 형식입니다(계좌번호 형식: A-xxxx). ");;
            System.out.println("다시 입력하세요!!!");
        }
        return account_number;
    }

    public String inputCustomerId() {
        String customer_id = null;
        while (true) {
            System.out.println("고객번호: ");
            try {
                customer_id = dis.readLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (validateNumber(customer_id, 'C')) break;
            System.out.print("잘못된 고객번호 형식입니다(고객번호 형식: C-xxxx). ");
            System.out.println("다시 입력하세요!!!");
        }
        return customer_id;
    }

    public int inputBalance() {
        int balance = 0;
        while (true) {
            System.out.println("잔액: ");
            try {
                balance = Integer.parseInt(dis.readLine());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (balance >= 100) break;
            System.out.println("잔액은 최소 100 이상이어야 합니다. 다시 입력하세요! : ");
        }
        return balance;
    }

    public boolean validateNumber(String str, char type) {
        if (str.length() == 6) {
            if (str.charAt(0) == type && str.charAt(1) =='-') {
                return isInteger(str.substring(2, 5));
            }
        }
        return false;
    }

    public boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
        } catch (Exception NumberFormatException) {
            System.err.println(NumberFormatException.getMessage());
            return false;
        }
        return true;
    }
}
