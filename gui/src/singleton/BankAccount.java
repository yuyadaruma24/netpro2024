package singleton;

public class BankAccount {
    private static BankAccount instance;
    private double balance;

    // コンストラクタをprivateにすることで外部からのインスタンス化を防ぐ
    private BankAccount() {
        this.balance = 0.0;
    }

    // シングルトンのインスタンスを取得するメソッド
    public static synchronized BankAccount getInstance() {
        if (instance == null) {
            instance = new BankAccount();
        }
        return instance;
    }

    // 残高を取得するメソッド
    public double getBalance() {
        return balance;
    }

    // 預金を行うメソッド
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // 引き出しを行うメソッド
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}
