package task1_concurrent;



public class Deposit implements Runnable {
    private AccountConcurrent accountConc;
    public Deposit(AccountConcurrent accountConc)
    {
        this.accountConc = accountConc;
    }
    public void run()
    {
        for (TransactionConc tr : accountConc.getInQueue())
        {
            accountConc.deposit(tr.getValue());
        }
    }

}
