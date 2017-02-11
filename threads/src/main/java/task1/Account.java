package task1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Account {
    private String accountNumber;
    private List<Transaction> inTransactions = new ArrayList<>();
    private List<Transaction> outTransactions = new ArrayList<>();

    public Account(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

}
