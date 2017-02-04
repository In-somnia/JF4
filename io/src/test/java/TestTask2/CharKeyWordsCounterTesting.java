package TestTask2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static task2.CharKeyWordsCounter.charKeyWordsCount;
import static task2.CharKeyWordsCounter.writeCharsToAFile;

public class CharKeyWordsCounterTesting {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите адрес файла, который необходимо считать: ");
            String fileName = reader.readLine();

            Map<String, Integer> mapForWriting = charKeyWordsCount(fileName);

            BufferedReader outReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите адрес файла, в который необходимо записать: ");
            String outputFileName = outReader.readLine();
            writeCharsToAFile(outputFileName, mapForWriting);
            reader.close();
            outReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
