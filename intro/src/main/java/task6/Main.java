package task6;


import java.io.*;
import static task6.Notepad.*;

/** <p> Main contains console interface which allows a user to choose the necessary command, and runs the corresponding method. </p> */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("Выберите действие: ");
            System.out.println("1 - добавить запись");
            System.out.println("2 - редактировать запись");
            System.out.println("3 - удалить запись");
            System.out.println("4 - показать все записи");
            System.out.println("0 - закрыть блокнот");
            String a = reader.readLine();
            switch(a)
            {
                case "1":
                    System.out.println("Введите текст записи:");
                    String strAdd = reader.readLine();
                    addNote(strAdd);
                    break;
                case "2":
                    showAllNotes();
                    System.out.println("Введите номер записи, которую необходимо изменить:");
                    int strEditNum = Integer.parseInt(reader.readLine());
                    System.out.println("Введите новый текст записи:");
                    String strEdit = reader.readLine();
                    editNote(strEditNum, strEdit);
                    break;
                case "3":
                    System.out.println("Введите номер записи, которую необходимо удалить:");
                    showAllNotes();
                    int strRemove = Integer.parseInt(reader.readLine());
                    removeNote(notes, strRemove);
                    break;
                case "4":
                    showAllNotes();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }
}
