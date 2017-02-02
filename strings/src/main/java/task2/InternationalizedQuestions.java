package task2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizedQuestions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int language;
        Locale locale;
        String invitation;
        System.out.println("Выберите язык");
        System.out.println("1 - русский");
        System.out.println("2 - English");

        language = Integer.parseInt(reader.readLine());

        while (true) {
            if (language == 1) {
                invitation = "Выберите номер вопроса. Чтобы выйти из программы, нажмите 0.";
                locale = new Locale("ru", "RU");
            } else {
                invitation = "Please, choose the question number. Press 0 to quit the program";
                locale = new Locale("en", "EN");
            }

            System.out.println(invitation);
            ResourceBundle bundle = ResourceBundle.getBundle("Questions", locale);
            System.out.println(bundle.getString("q1"));
            System.out.println(bundle.getString("q2"));
            System.out.println(bundle.getString("q3"));
            System.out.println(bundle.getString("q4"));
            System.out.println(bundle.getString("q5"));
            String s = reader.readLine();

            ResourceBundle answerBundle = ResourceBundle.getBundle("Answers", locale);
            switch (s) {
                case "1":
                    System.out.println(answerBundle.getString("a1"));
                    break;
                case "2":
                    System.out.println(answerBundle.getString("a2"));
                    break;
                case "3":
                    System.out.println(answerBundle.getString("a3"));
                    break;
                case "4":
                    System.out.println(answerBundle.getString("a4"));
                    break;
                case "5":
                    System.out.println(answerBundle.getString("a5"));
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }


    }
}
