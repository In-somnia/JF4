package task1;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileWatcherMethods {

    public static void showDirectory(String path) throws FileNotFoundException
    {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        System.out.println("В выбранной директории находятся следующие файлы:");
        //noinspection ConstantConditions
        for (File current : listOfFiles)
        {
            if(current.exists())
            {
                System.out.println(current.getName());
            } else
            {
                System.out.println("Файл не существует.");
                throw new FileNotFoundException();
            }
        }
    }
    public static void createFile(String path, String fileName) throws FileAlreadyExistsException
    {
        Path filePath = Paths.get(path, fileName);
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Файл успешно создан.");
        } else {
            throw new FileAlreadyExistsException("В указанной директории уже есть файл.");
        }
    }
    public static void recordFile(String path, String fileName) throws IOException
    {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Path filePath = Paths.get(path, fileName);
            List<String> textForWriting = new ArrayList<>();
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.println("Введите текст, который необходимо записать: ");
                while (true) {
                    String str = reader.readLine();
                    if (!str.equals(""))
                    {
                        textForWriting.add(str);
                    } else
                    {
                        break;
                    }
                }
                Files.write(filePath, textForWriting);
                System.out.println("Файл успешно записан.");
            } else {

                System.out.println("Введите текст, который необходимо записать: ");
                while (true) {
                    String str = reader.readLine();
                    if (!str.equals(""))
                    {
                        textForWriting.add(str);
                    } else
                    {
                        break;
                    }
                }
                Files.write(filePath, textForWriting);
                System.out.println("Файл записан.");
            }
        }

    public static void rerecordFile(String path, String fileName) throws IOException
    {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Path filePath = Paths.get(path, fileName);
            List<String> listForWriting = new ArrayList<>();
            if (!Files.exists(filePath)) {
                throw new FileNotFoundException("Такого файла не существует.");
            } else {
                System.out.println("Введите текст, который необходимо дозаписать: ");
                while (true) {
                    String str = reader.readLine();
                    if (!str.equals(""))
                    {
                        listForWriting.add(str);
                    } else
                    {
                        break;
                    }
                }
                Files.write(filePath, listForWriting, StandardOpenOption.APPEND);
                System.out.println("Файл успешно дозаписан.");
            }
        }

    public static void removeFile(String path, String fileName) throws FileNotFoundException
    {
        Path filePath = Paths.get(path, fileName);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("Такого файла не существует.");
        } else {
            try {
                Files.delete(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Файл успешно удален.");
        }
    }
}
