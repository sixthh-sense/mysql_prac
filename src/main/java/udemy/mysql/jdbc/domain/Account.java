package udemy.mysql.jdbc.domain;

public class Account {
    private String account_number;
    private String customer_id;
    private int balance;

    public Account() {
        account_number = null;
        customer_id = null;
        balance = 0;
    }

    public void setAccountNumber(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setCustomerId(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomerId() {
        return customer_id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}
