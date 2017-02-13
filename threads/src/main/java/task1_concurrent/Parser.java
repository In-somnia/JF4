package task1_concurrent;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.lang.Integer.parseInt;
import static javax.xml.stream.XMLStreamConstants.CHARACTERS;
import static javax.xml.stream.XMLStreamConstants.END_ELEMENT;
import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

public class Parser {

    public static ConcurrentLinkedQueue<TransactionConc> processXML(XMLStreamReader reader) throws XMLStreamException
    {
        ConcurrentLinkedQueue<TransactionConc>trQueue = new ConcurrentLinkedQueue<>();
        TransactionConc transactionConc = null;
        TagEnum tag = null;
        while(reader.hasNext())
        {
            int type = reader.next();
            switch(type)
            {
                case START_ELEMENT:
                    tag = TagEnum.getTagEnum(reader.getLocalName());
                    if (tag == TagEnum.TRANSACTION)
                    {
                        transactionConc = new TransactionConc();
                        transactionConc.setId(parseInt(reader.getAttributeValue(null, "id")));
                    }
                    break;
                case CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty())
                    {
                        break;
                    }
                    //noinspection ConstantConditions
                    switch(tag)
                    {
                        case DATE:
                            //noinspection ConstantConditions
                            transactionConc.setDate(text);
                            break;
                        case VALUE:
                            //noinspection ConstantConditions
                            transactionConc.setValue(parseInt(text));
                            break;
                        case SENDER:
                            //noinspection ConstantConditions
                            transactionConc.setSender(text);
                            break;
                        case RECEIVER:
                            //noinspection ConstantConditions
                            transactionConc.setReceiver(text);
                            break;
                        case STATE:
                            //noinspection ConstantConditions
                            transactionConc.setState(text);
                            break;
                    }
                    break;
                case END_ELEMENT:
                    tag = TagEnum.getTagEnum(reader.getLocalName());
                    if (tag == TagEnum.TRANSACTION)
                    {
                        trQueue.add(transactionConc);
                    }
            }
        }
        return trQueue;
    }

    public static void transSelector(ConcurrentLinkedQueue<TransactionConc> trQueue, ConcurrentLinkedQueue<AccountConcurrent> accQueue)
    {
        for (TransactionConc trc : trQueue)
        {
            for (AccountConcurrent acc : accQueue)
            {
                if (trc.getSender().equals(acc.getNumber()))
                {
                    acc.getOutQueue().add(trc);
                }
                else if (trc.getReceiver().equals(acc.getNumber()))
                {
                    acc.getInQueue().add(trc);
                }
            }
        }
    }

    public static int checkBalance(String number, ConcurrentLinkedQueue<AccountConcurrent> accQueue) throws NullPointerException
    {
        int balance = 0;
        if (isAvailable(number, accQueue))
        {
            for (AccountConcurrent ac : accQueue)
            {
                if(ac.getNumber().equals(number))
                {
                    balance = ac.getValue();
                }
            }
        }
        else
        {
            throw new NullPointerException();
        }
        return balance;
    }

    public static boolean isAvailable(String number, ConcurrentLinkedQueue<AccountConcurrent> accQueue)
    {
        boolean isAvailable = false;
        for (AccountConcurrent ac : accQueue)
        {
            if (ac.getNumber().equals(number))
            {
                isAvailable = true;
            }
        }
        return isAvailable;
    }
}
