package task1;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private String accountNumber;
    private int value;
    private List<Transaction> inTransactions = new ArrayList<>();
    private List<Transaction> outTransactions = new ArrayList<>();

    public Account(String accountNumber, int value)
    {
        this.accountNumber = accountNumber;
        this.value = value;
    }
    void deposit(int amount)
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
    void withdraw(int amount)
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
