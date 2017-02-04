package task1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ByteKeyWordsCounter {
    public static Map<String, Integer> countKeyWordsInAFile(String fileName)
    {
        Map<String, Integer> map = new HashMap<>();
        String[] keyJavaWords = {"byte", "short", "int", "long", "char", "float", "double", "boolean", "if", "else",
                "switch", "case", "default", "while", "do", "break", "continue", "for", "try", "catch", "finally",
                "throw", "throws", "private", "protected", "public", "import", "package", "class", "interface", "extends",
                "implements", "static", "final", "void", "abstract", "native", "new", "return", "this", "super", "synchronized",
                "volatile", "instanceOf", "enum", "assert", "transient", "strictfp"};

        for (String x : keyJavaWords)
        {
            map.put(x, 0);
        }
        int[] arr = readFile(fileName);
        return extractWords(arr, map);
    }

    private static int[] readFile(String fileName)
    {
        int[] arr = null;
        try {
            FileInputStream inStream = new FileInputStream(fileName);
            arr = new int[inStream.available()];
            int q = 0;
            while(inStream.available() > 0)
            {
                int data = inStream.read();
                arr[q] = data;
                q++;
            }
            inStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    private static Map<String, Integer> extractWords(int[] arr, Map<String, Integer> map)
    {
        Map<String, Integer> map1 = new HashMap<>();
        List<Character> list = new ArrayList<>();
        String str = "";

        for (int i = 0; i < arr.length; i++)
        {
            if ((arr[i] > 64 && arr[i] < 91) || (arr[i] > 96 && arr[i] < 123))
            {
                list.add(((char)arr[i]));
            }
            else {
                for (char j : list)
                {
                    str += j;
                }
                map1 = countKeyWords(str, map);
                list.clear();
                str = "";
            }
        }
        return map1;
    }

    private static Map<String, Integer> countKeyWords(String s, Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            int value = pair.getValue();
            String key = pair.getKey();
            if (s.equals(key))
            {
                map.put(key, value + 1);
            }
        }
        return map;
    }

    public static void writeBytesToAFile(String outputName, Map<String, Integer> map)
    {
        try{
            FileOutputStream out = new FileOutputStream(outputName);
            for (Map.Entry<String, Integer> pair : map.entrySet())
            {
                byte[] strBuffer = pair.getKey().getBytes();
                byte[] intBuffer = pair.getValue().toString().getBytes();
                byte[] bufferForSpaceAndDash = {32, 45, 32};
                byte space = 32;
                out.write(strBuffer);
                out.write(bufferForSpaceAndDash);
                out.write(intBuffer);
                out.write(space);
                out.flush();
            }
            out.close();
            System.out.println("Файл записан.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}



