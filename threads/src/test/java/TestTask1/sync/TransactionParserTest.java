package TestTask1.sync;

import lombok.SneakyThrows;
import task1.sync.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static task1.sync.ParsingAndMethods.checkBalance;
import static task1.sync.ParsingAndMethods.process;
import static task1.sync.ParsingAndMethods.transactionSelector;


public class TransactionParserTest {
@SneakyThrows
    public static void main(String[] args) throws FileNotFoundException {

        List<Account> listOfAccounts = new ArrayList<>();
        listOfAccounts.add(new Account("77755544443333", 8000));
        listOfAccounts.add(new Account("9999888877776666", 500));
        listOfAccounts.add(new Account("1212111177779999", 0));

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
                        Account currentAccount = null;

                        if (ParsingAndMethods.accountIsAvailable(num, listOfAccounts))
                        {
                            for (Account x : listOfAccounts)
                            {
                                if (x.getAccountNumber().equals(num))
                                {
                                    currentAccount = x;
                                }
                            }
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
                        }
                        else
                        {
                            System.out.println("Счет не найден!");
                        }
                        break;
                    case "2":
                        System.out.println("Введите номер счета: ");
                        String accNumber = strReader.readLine();
                        Account current = null;
                        if (ParsingAndMethods.accountIsAvailable(accNumber, listOfAccounts))
                        {
                            for (Account x : listOfAccounts)
                            {
                                if (x.getAccountNumber().equals(accNumber))
                                {
                                    current = x;
                                    break;
                                }
                            }
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
    }
}
