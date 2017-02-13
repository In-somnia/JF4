package task1;

import lombok.Data;

@Data
public class Transaction  {
    private int id;
    private String date;
    private int value;
    private String state;
    private String sender;
    private String receiver;

}
