package task1;

import lombok.Getter;

@Getter
public class WithdrawalThread implements Runnable {
    private Account account;
    public WithdrawalThread(Account account)
    {
        this.account = account;
    }

    public void run()
    {
        for(Transaction tr : account.getOutTransactions())
        {
            synchronized (account)
            {
                account.withdraw(tr.getValue());
            }
        }
    }
}
