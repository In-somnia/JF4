package task1;

import lombok.Getter;

@Getter
public class DepositThread implements Runnable{
    private Account account;
    public DepositThread(Account account)
    {
        this.account = account;
    }

    public void run()
    {
        for(Transaction tr : account.getInTransactions())
        {
            synchronized (account)
            {
                account.deposit(tr.getValue());
            }
        }
    }
}
