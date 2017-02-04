package TestTask1;

import java.io.*;
import java.util.Map;
import static task1.ByteKeyWordsCounter.countKeyWordsInAFile;
import static task1.ByteKeyWordsCounter.writeBytesToAFile;


public class ByteKeyWordsCounterTesting {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите адрес файла, который необходимо считать: ");
            String fileName = reader.readLine();

            Map<String, Integer> finalMap = countKeyWordsInAFile(fileName);

            BufferedReader outReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите адрес файла, в который необходимо записать: ");
            String outName = outReader.readLine();

            writeBytesToAFile(outName, finalMap);
            reader.close();
            outReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

