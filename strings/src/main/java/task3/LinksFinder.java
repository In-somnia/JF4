package task3;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksFinder {
    public static List<String> findLinksInTheMiddle()
    {
        List<String> LinksInText2 = new ArrayList<>();
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IT\\JAVA\\lectures" +
                    "\\Модуль 3\\Java.SE.03.Information handling_task_attachment.html"), "cp1251"));

            String str;
            String temp = "";
            String matchedString;

            String linkInTextPattern = "[А-Я].[^.]*[(][Рр]ис[.]?\\s?\\d{1,2}[)]\\s?.[^.()]*\\.";
            Pattern linkInText = Pattern.compile(linkInTextPattern);

            while ((str = reader.readLine()) != null ) {

                Matcher linkInTextMatcher = linkInText.matcher(str);
                str += temp;
                if (linkInTextMatcher.find())
                {
                    matchedString = linkInTextMatcher.group();
                    LinksInText2.add(matchedString);
                    temp = str.substring(linkInTextMatcher.end());
                }
                else
                {
                    temp = str;
                }
            }

            reader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        return LinksInText2;
    }

    public static List<String> findLinksInTheEnd()
    {
        List<String> LinksInText = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IT\\JAVA\\lectures" +
                    "\\Модуль 3\\Java.SE.03.Information handling_task_attachment.html"), "cp1251"));

            String str;
            String temp = "";
            String matchedString;

            String linkInTextPattern = "[А-Я].[^.]*[(][Рр]ис[.]?\\s?\\d{1,2}[)][^.]?\\.";
            Pattern linkInText = Pattern.compile(linkInTextPattern);

            while ((str = reader.readLine()) != null ) {

                Matcher linkInTextMatcher = linkInText.matcher(str);
                str += temp;
                if (linkInTextMatcher.find())
                {
                    matchedString = linkInTextMatcher.group();
                    LinksInText.add(matchedString);
                    temp = str.substring(linkInTextMatcher.end());
                }
                else
                {
                    temp = str;
                }
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return LinksInText;
    }
}
