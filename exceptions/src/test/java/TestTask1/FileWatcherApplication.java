package TestTask1;


import java.io.*;
import java.nio.file.*;

import task1.FileWatcherMethods;

public class FileWatcherApplication {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Введите путь к файлу: ");
            String path = reader.readLine();
            try {
                FileWatcherMethods.showDirectory(path);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не существует. " + e);
            }
            while (true) {
                System.out.println("Выберите дальнейшие действия: ");
                System.out.println("1 - указать другой путь");
                System.out.println("2 - создать текстовый файл в текущей директории");
                System.out.println("3 - записать текстовый файл");
                System.out.println("4 - дозаписать текстовый файл");
                System.out.println("5 - удалить текстовый файл");
                System.out.println("0 - выйти из программы");
                String choice = reader.readLine();
                switch (choice) {
                    case "1":
                        System.out.println("Введите путь к файлу: ");
                        path = reader.readLine();
                        FileWatcherMethods.showDirectory(path);
                        reader.close();
                        break;
                    case "2":
                        try {
                            System.out.println("Введите полное имя файла (с расширением), который необходимо создать: ");
                            String fileName = reader.readLine();
                            FileWatcherMethods.createFile(path, fileName);
                        } catch (FileAlreadyExistsException e) {
                            System.out.println("Файл с таким именем уже существует. " + e);
                        }
                        break;
                    case "3":
                        System.out.println("Введите полное имя файла (с расширением), в который необходимо записать: ");
                        String fileName = reader.readLine();
                        try {
                            FileWatcherMethods.recordFile(path, fileName);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "4":
                        System.out.println("Введите полное имя файла (с расширением), в который необходимо дозаписать: ");
                        fileName = reader.readLine();
                        try {
                            FileWatcherMethods.rerecordFile(path, fileName);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                        break;
                        case "5":
                            System.out.println("Введите полное имя файла (с расширением), в который необходимо удалить: ");
                            fileName = reader.readLine();
                            try {
                                FileWatcherMethods.removeFile(path, fileName);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "0":
                            return;
                        default:
                            break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
