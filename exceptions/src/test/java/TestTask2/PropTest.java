package TestTask2;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import task2.KeyIsMissingException;
import task2.PropOpener;


public class PropTest {
    public static void main(String[] args)  {
        try {
            Properties properties = PropOpener.getProperties("C:/Users/Julia/IdeaProjects/JF4/exceptions/src/main/" +
                    "resources/test.properties");
            try {
                PropOpener.getValue(properties, "key1");
                PropOpener.getValue(properties, "key2");
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
