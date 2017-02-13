package task1_concurrent;

import lombok.Data;

@Data
public class TransactionConc {
    private int id;
    private String date;
    private int value;
    private String state;
    private String sender;
    private String receiver;
}
