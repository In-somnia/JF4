package task2;

import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Getter
public class ReadingThread implements Runnable{
    private String name;
    public ReadingThread(String name)
    {
        this.name = name;
    }
    public void run()
    {
        try {
            Properties properties = PropOpener.getProperties("C:/Users/Julia/IdeaProjects/JF4/exceptions/src/main/" +
                    "resources/test.properties");

                try {
                    System.out.print(getName() + ": ");
                    PropOpener.getValue(properties, "key1");
                    System.out.print(getName() + ": ");
                    PropOpener.getValue(properties, "key2");
                    System.out.print(getName() + ": ");
                    PropOpener.getValue(properties, "key3");


                } catch (KeyIsMissingException e) {
                    e.printStackTrace();
                }

        } catch(FileNotFoundException e) {
            System.out.println("Файл не существует.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
