package task1;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private String accountNumber;
    private String holderName;
    private int value;
    private List<Transaction> inTransactions = new ArrayList<>();
    private List<Transaction> outTransactions = new ArrayList<>();

    public Account(String accountNumber, String holderName, int value)
    {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.value = value;
    }
    synchronized void deposit(int amount)
    {
        this.value += amount;
        try{
            Thread.sleep(25);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        this.setValue(value);
    }
    synchronized void withdraw(int amount)
    {
        this.value -= amount;
        try{
            Thread.sleep(25);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        this.setValue(value);
    }
}
