package task1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;

public class CrazyLogger {

    private static StringBuilder sb = new StringBuilder();

    private static StringBuilder saveLog(LocalDate date, LocalTime time, String s)
    {
       Formatter formatter = new Formatter();
        sb.append(formatter.format("%d-%d-%d : %d-%d - %s", date.getDayOfMonth(), date.getMonthValue(), date.getYear(), time.getHour(), time.getMinute(), s + "\n"));

        return sb;
    }

    private static void printLog(LocalDate date1, LocalTime time1, String s)
    {
        System.out.printf("%d-%d-%d : %d-%d - %s", date1.getDayOfMonth(), date1.getMonthValue(), date1.getYear(), time1.getHour(), time1.getMinute(), s + "\n");
    }

    public static void newLog(String str)
    {

        LocalDate today = LocalDate.now();
        LocalTime rightNow = LocalTime.now();

        saveLog(today, rightNow, str);
        printLog(today, rightNow, str);
    }

    public static void searchInALog()
    {
        System.out.println("Введите текст для поиска: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String x = reader.readLine();
            String[] arrayOfWords = sb.toString().split("\n");
            for (String j : arrayOfWords)
            {
                if (j.contains(x))
                {
                    System.out.println(j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
