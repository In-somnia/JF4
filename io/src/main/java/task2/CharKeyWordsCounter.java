package task2;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CharKeyWordsCounter {
    public static Map<String, Integer> charKeyWordsCount(String fileName)
    {
        Map<String, Integer> words = new HashMap<>();
        String[] keyJavaWords = {"byte", "short", "int", "long", "char", "float", "double", "boolean", "if", "else",
                "switch", "case", "default", "while", "do", "break", "continue", "for", "try", "catch", "finally",
                "throw", "throws", "private", "protected", "public", "import", "package", "class", "interface", "extends",
                "implements", "static", "final", "void", "abstract", "native", "new", "return", "this", "super", "synchronized",
                "volatile", "instanceOf", "enum", "assert", "transient", "strictfp"};
        for (String m : keyJavaWords)
        {
            words.put(m, 0);
        }
        List<Character> readChars = readCharsFromFile(fileName);
        return extractWords(readChars, words);
    }


private static List<Character> readCharsFromFile(String fileName)
    {
        List<Character> charList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);

            while (fr.ready())
            {
                int data = fr.read();
                char ch = (char) data;
                charList.add(ch);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return charList;
    }

    private static Map<String, Integer> extractWords(List<Character> charList, Map<String, Integer> map)
    {
        Map<String, Integer> resultMap = new HashMap<>();
        String s = "";
        for (int i = 0; i < charList.size(); i++)
        {
            if ((charList.get(i) >= 65 && charList.get(i) <= 90) || ((charList.get(i) >= 97 && charList.get(i) <= 122)))
            {
                s += charList.get(i).toString();
            }
            else
            {
                resultMap = countWords(s, map);
                s = "";
            }
        }
        return resultMap;
    }

    private static Map<String, Integer>  countWords(String s, Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            int value = pair.getValue();
            if (pair.getKey().equals(s))
            {
                map.put(pair.getKey(), value + 1);
            }
        }
        return map;
    }

    public static void writeCharsToAFile(String outputName, Map<String, Integer> map)
    {
        try {
            FileWriter fw = new FileWriter(outputName);
            for (Map.Entry<String, Integer> pair : map.entrySet())
            {

                fw.write(pair.getKey());
                fw.write(32);
                fw.write(45);
                fw.write(32);
                fw.write(pair.getValue().toString());
                fw.write(32);
            }
            System.out.println("Файл записан.");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
