package task1_concurrent;

import lombok.Data;

import java.util.concurrent.ConcurrentLinkedQueue;
@Data
public class AccountConcurrent {
    private String number;
    private int value;
    private ConcurrentLinkedQueue<TransactionConc> inQueue = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<TransactionConc> outQueue = new ConcurrentLinkedQueue<>();

    public AccountConcurrent(String number, int value)
    {
        this.number = number;
        this.value = value;
    }
    void deposit(int sum)
    {
        this.value += sum;
        try
        {
            Thread.sleep(25);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        this.setValue(value);
    }

    void withdraw(int sum)
    {
        this.value -= sum;
        try
        {
            Thread.sleep(25);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        this.setValue(value);
    }
}
