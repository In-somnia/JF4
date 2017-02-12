package task1;


import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static javax.xml.stream.XMLStreamConstants.*;


public class ParsingAndMethods {

    public static List<Transaction> process(XMLStreamReader reader) throws XMLStreamException
    {
        List<Transaction> listOfTransactions = new ArrayList<>();
        Transaction transaction = null;
        TagNames element = null;
        while (reader.hasNext())
        {
            int type = reader.next();
            switch(type)
            {
                case START_ELEMENT:
                    element = TagNames.getTagName(reader.getLocalName());
                    if (element == TagNames.TRANSACTION)
                    {
                        transaction = new Transaction();
                        transaction.setId(parseInt(reader.getAttributeValue(null, "id")));
                    }
                    break;
                case CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty())
                        break;
                    //noinspection ConstantConditions
                    switch(element)
                    {
                        case DATE:
                            //noinspection ConstantConditions
                            transaction.setDate(text);
                            break;
                        case VALUE:
                            //noinspection ConstantConditions
                            transaction.setValue(parseInt(text));
                            break;
                        case SENDER:
                            //noinspection ConstantConditions
                            transaction.setSender(text);
                            break;
                        case RECEIVER:
                            //noinspection ConstantConditions
                            transaction.setReceiver(text);
                            break;
                        case STATE:
                            //noinspection ConstantConditions
                            transaction.setState(text);
                            break;
                    }
                    break;
                case END_ELEMENT:
                    element = TagNames.getTagName(reader.getLocalName());
                    if (element == TagNames.TRANSACTION)
                    {
                        listOfTransactions.add(transaction);
                    }
            }
        }
        return listOfTransactions;
    }

    public static void transactionSelector(List<Transaction> listOfTransactions, List<Account> listOfAccounts)
    {
        for (Transaction tr : listOfTransactions)
        {
            for (Account a : listOfAccounts)
            {
                if (tr.getSender().equals(a.getAccountNumber()))
                {
                    a.getOutTransactions().add(tr);
                }
                else if (tr.getReceiver().equals(a.getAccountNumber()))
                {
                    a.getInTransactions().add(tr);
                }
            }
        }
    }
    public static int checkBalance(String accountNumber, List<Account> listOfAccounts)
    {
        int balance = 0;
        for (Account n : listOfAccounts)
        {
            if (n.getAccountNumber().equals(accountNumber))
            {
                balance = n.getValue();
            }
        }
        return balance;
    }
}
