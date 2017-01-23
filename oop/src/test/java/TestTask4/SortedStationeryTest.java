package TestTask4;

import task3.*;
import task4.NameAndPriceSortedStationery;
import task4.NameSortedStationery;
import task4.PriceSortedStationery;
import java.util.*;

public class SortedStationeryTest extends PriceSortedStationery {

    public static void main(String[] args) {
        Comparator<Stationery> comp = new PriceSortedStationery();
        Comparator<Stationery> comp1 = new NameSortedStationery();
        Comparator<Stationery> comp2 = new NameAndPriceSortedStationery();
        List<Stationery> stationeryForABeginner = new ArrayList<>();

        stationeryForABeginner.add(new NoteBook("Alt", 40, 12, "green", "squared", "тетрадь"));
        stationeryForABeginner.add(new NoteBook("Alt", 35, 12, "blue", "ruled", "тетрадь"));
        stationeryForABeginner.add(new Pen("Stabilo", 50, "blue", "ручка"));
        stationeryForABeginner.add(new Pen("Stabilo", 50, "black", "ручка"));
        stationeryForABeginner.add(new Pencil("Koh-i-Noor", 35, "2B", "карандаш"));
        stationeryForABeginner.add(new Ruler("STAMM", 20, 25, "brown", "wood", "линейка"));
        stationeryForABeginner.add(new Eraser("Koh-i-Noor", 15, "white", "ластик"));

        Collections.sort(stationeryForABeginner, comp);

           for (Stationery o : stationeryForABeginner)
            {
                System.out.println("Сортировка по цене: " + o.toString());
            }

        Collections.sort(stationeryForABeginner, comp1);

            for (Stationery b : stationeryForABeginner)
            {
                System.out.println("Сортировка по произодителю: " + b.toString());
            }

        Collections.sort(stationeryForABeginner, comp2);

            for (Stationery c : stationeryForABeginner)
            {
                System.out.println("Сортировка производителю и цене: " + c.toString());
            }
    }
}
