package TestTask3;

import task3.*;

import java.util.ArrayList;
import java.util.List;


public class StationaryForBeginners {
    public static void main(String[] args) {

        List<Stationery> stationeryForABeginner = new ArrayList<>();

        stationeryForABeginner.add(new NoteBook("Alt", 40, 12, "green", "squared", "тетрадь"));
        stationeryForABeginner.add(new NoteBook("Alt", 35, 12, "blue", "ruled", "тетрадь"));
        stationeryForABeginner.add(new Pen("Stabilo", 50, "blue", "ручка"));
        stationeryForABeginner.add(new Pen("Stabilo", 50, "black", "ручка"));
        stationeryForABeginner.add(new Pencil("Koh-i-Noor", 35, "2B", "карандаш"));
        stationeryForABeginner.add(new Ruler("STAMM", 20, 25, "brown", "wood", "линейка"));
        stationeryForABeginner.add(new Eraser("Koh-i-Noor", 15, "white", "ластик"));

        System.out.println("Набор новичка: ");
        for (Stationery item : stationeryForABeginner)
        {
            System.out.println(item.toString());
        }
    }
}
