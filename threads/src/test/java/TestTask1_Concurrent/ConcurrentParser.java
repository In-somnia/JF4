package TestTask1_Concurrent;


import lombok.SneakyThrows;
import task1_concurrent.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

import static task1_concurrent.Parser.isAvailable;
import static task1_concurrent.Parser.processXML;
import static task1_concurrent.Parser.transSelector;

public class ConcurrentParser {
    @SneakyThrows
    public static void main(String[] args) {
        ConcurrentLinkedQueue<AccountConcurrent> accQueue = new ConcurrentLinkedQueue<>();
        accQueue.add(new AccountConcurrent("77755544443333", 9000));
        accQueue.add(new AccountConcurrent("9999888877776666", 1000));
        accQueue.add(new AccountConcurrent("1212111177779999", 500));

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream input = new FileInputStream("C:/Users/Julia/IdeaProjects/JF4/threads/src/test/resources/transactions.xml");
        XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

        ConcurrentLinkedQueue<TransactionConc> trQueue = processXML(reader);
        transSelector(trQueue, accQueue);

        for (AccountConcurrent acc : accQueue)
        {
            Thread t1 = new Thread(new Deposit(acc));
            Thread t2 = new Thread(new Withdraw(acc));
            t1.start();
            t2.start();
        }

        BufferedReader strReader = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            System.out.println("Выберите необходимое действие: ");
            System.out.println("1 - Посмотреть входящие транзакции: ");
            System.out.println("2 - Посмотреть исходящие транзакции: ");
            System.out.println("3 - Проверить баланс: ");
            System.out.println("0 - Выход из программы");
            String choice = strReader.readLine();
            switch(choice)
            {
                case "1":
                    System.out.println("Введите номер счета: ");
                    String num = strReader.readLine();
                    AccountConcurrent currentAccount = null;
                    if (isAvailable(num, accQueue))
                    {
                        for (AccountConcurrent a : accQueue)
                        {
                            if (a.getNumber().equals(num))
                            {
                                currentAccount = a;
                            }
                        }
                        //noinspection ConstantConditions
                        ConcurrentLinkedQueue<TransactionConc> currentTr = currentAccount.getInQueue();
                        if (currentTr.size() == 0)
                        {
                            System.out.println("Нет входящих транзакций.");
                        }
                        for (TransactionConc t : currentTr)
                        {
                            System.out.printf("Date: %s, id: %d, Value: %s, Sender: %s, Receiver: %s, State: %s%n",
                                    t.getDate(), t.getId(), t.getValue(), t.getSender(), t.getReceiver(), t.getState());
                        }
                    }
                    else
                    {
                        System.out.println("Счет не найден!");
                    }
                    break;
                case "2":
                    System.out.println("Введите номер счета: ");
                    String accNumber = strReader.readLine();
                    AccountConcurrent current = null;
                    if (isAvailable(accNumber, accQueue))
                    {
                        for (AccountConcurrent ac : accQueue)
                        {
                            if (ac.getNumber().equals(accNumber))
                            {
                                current = ac;
                            }
                        }
                        //noinspection ConstantConditions
                        ConcurrentLinkedQueue<TransactionConc> currentTr = current.getOutQueue();
                        if (currentTr.size() == 0)
                        {
                            System.out.println("Нет исходящих транзакций.");
                        }
                        for (TransactionConc t : currentTr)
                        {
                            System.out.printf("Date: %s, id: %d, Value: %s, Sender: %s, Receiver: %s, State: %s%n",
                                    t.getDate(), t.getId(), t.getValue(), t.getSender(), t.getReceiver(), t.getState());
                        }
                    }
                    else
                    {
                        System.out.println("Счет не найден!");
                    }
                    break;
                case "3":
                    System.out.println("Введите номер счета: ");
                    String number = strReader.readLine();
                    try {
                        System.out.printf("Баланс счета номер %s составляет: %d$%n", number, Parser.checkBalance(number, accQueue));
                        } catch(NullPointerException e)
                    {
                        System.out.println("Счет не найден!");
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Сначала выберите необходимое действие (укажите номер действия в диапазоне от 0 до 3).");
                    break;
            }
        }
    }
}

