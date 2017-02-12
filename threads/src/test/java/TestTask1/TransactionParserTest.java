package TestTask1;

import task1.Account;
import task1.DepositThread;
import task1.Transaction;
import task1.WithdrawalThread;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


import static task1.ParsingAndMethods.checkBalance;
import static task1.ParsingAndMethods.process;
import static task1.ParsingAndMethods.transactionSelector;


public class TransactionParserTest {
    public static void main(String[] args) throws FileNotFoundException {

        List<Account> listOfAccounts = new ArrayList<>();
        listOfAccounts.add(new Account("77755544443333", "Иванов Иван",8000));
        listOfAccounts.add(new Account("9999888877776666", "Петров Петр", 500));
        listOfAccounts.add(new Account("1212111177779999", "Smith, Jack", 0));

        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream input = new FileInputStream("C:/Users/Julia/IdeaProjects/JF4/threads/src/test/resources/transactions.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            List<Transaction> list = process(reader);

            transactionSelector(list, listOfAccounts);

            for (Account a: listOfAccounts)
            {
                Thread t1 = new Thread(new DepositThread(a));
                Thread t2 = new Thread(new WithdrawalThread(a));
                t1.start();
                t2.start();
            }
        } catch(XMLStreamException e)
        {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true)
            {
                System.out.println("Выберите необходимое действие: ");
                System.out.println("1 - Посмотреть входящие транзакции: ");
                System.out.println("2 - Посмотреть исходящие транзакции: ");
                System.out.println("3 - Проверить баланс: ");
                System.out.println("0 - Выход из программы");
                String choice = reader.readLine();
                switch(choice)
                {
                    case "1":
                        System.out.println("Введите номер счета: ");
                        String num = reader.readLine();
                        Account currentAccount = null;
                        for (Account x : listOfAccounts)
                        {
                            if (x.getAccountNumber().equals(num))
                            {
                               currentAccount = x;
                                break;
                            }
                        }
                        try {
                            //noinspection ConstantConditions
                            List<Transaction> currentTr = currentAccount.getInTransactions();
                            if (currentTr.size() == 0)
                            {
                                System.out.println("Нет входящих транзакций.");
                            }
                            for (Transaction t : currentTr)
                            {
                                System.out.printf("Date: %s, id: %d, Value: %s, Sender: %s, Receiver: %s, State: %s%n",
                                        t.getDate(), t.getId(), t.getValue(), t.getSender(), t.getReceiver(), t.getState());
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Счет не найден!");
                        }
                        break;
                    case "2":
                        System.out.println("Введите номер счета: ");
                        String accNumber = reader.readLine();
                        Account current = null;
                        for (Account x : listOfAccounts)
                        {
                            if (x.getAccountNumber().equals(accNumber))
                            {
                                current = x;
                                break;
                            }
                        }
                        try {
                            //noinspection ConstantConditions
                            List<Transaction> currentTrans = current.getOutTransactions();
                            if (currentTrans.size() == 0)
                            {
                                System.out.println("Нет исходящих транзакций.");
                            }
                            for (Transaction t : currentTrans)
                            {
                                System.out.printf("Date: %s, id: %d, Value: %s, Sender: %s, Receiver: %s, State: %s%n",
                                        t.getDate(), t.getId(), t.getValue(), t.getSender(), t.getReceiver(), t.getState());
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Счет не найден!");
                        }
                        break;
                    case "3":
                        System.out.println("Введите номер счета: ");
                        String number = reader.readLine();
                        try {
                            System.out.printf("Баланс счета номер %s составляет: %d$%n", number, checkBalance(number, listOfAccounts));
                        } catch (NullPointerException e) {
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
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
