package TestTask2;

import lombok.SneakyThrows;
import task2.cp.BookManager;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ApplicationDAO {
    @SneakyThrows
    public static void main(String[] args) {
        BookManager bm = new BookManager();
        System.out.println("____________________________________" + "\n");
        System.out.println("Приложение \"Домашняя библиотека\": ");
        System.out.println("На данный момент Ваша домашняя коллекция выглядит так: " + "\n");
        bm.showCollection();
        while(true)
        {

            System.out.println("____________________________________");
            System.out.println("Выберите необходимые действия:");
            System.out.println("1 - посмотреть коллекцию");
            System.out.println("2 - добавить книгу в коллекцию");
            System.out.println("3 - удалить книгу из коллекции");
            System.out.println("4 - найти книгу по автору");
            System.out.println("5 - найти книгу по названию");
            System.out.println("0 - закрыть программу");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                String choice = reader.readLine();
                switch(choice)
                {
                    case "1":
                        System.out.println("Текущее состояние Вашей коллекции: " + "\n");
                        bm.showCollection();
                        break;
                    case "2":
                        System.out.println("Введите автора книги, которую необходимо добавить: ");
                        String author = reader.readLine();
                        System.out.println("Введите название книги, которую необходимо добавить: ");
                        String name = reader.readLine();
                        bm.insertABook(author, name);
                        break;
                    case "3":
                        System.out.println("Введите название книги, которую необходимо удалить: " + "\n");
                        bm.showCollection();
                        String bookName = reader.readLine();
                        bm.deleteABook(bookName);
                        break;
                    case "4":
                        System.out.println("Введите автора книги, которую необходимо найти: ");
                        String findAuthor = reader.readLine();
                        bm.findByAuthor(findAuthor);
                        break;
                    case "5":
                        System.out.println("Введите название книги, которую необходимо найти: ");
                        String findName = reader.readLine();
                        bm.findByName(findName);
                        break;
                    case "0":
                        return;
                    default:
                        break;
                }
        }
    }

}
