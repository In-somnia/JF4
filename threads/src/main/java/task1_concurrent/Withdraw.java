package task1_concurrent;

public class Withdraw implements Runnable {
    private AccountConcurrent accountConc;
    public Withdraw(AccountConcurrent accountConc)
    {
        this.accountConc = accountConc;
    }
    public void run()
    {
        for (TransactionConc tr : accountConc.getOutQueue())
        {
            accountConc.withdraw(tr.getValue());
        }
    }
}
