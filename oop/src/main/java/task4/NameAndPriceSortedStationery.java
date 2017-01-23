package task4;

import task3.Stationery;
import java.util.Comparator;


public class NameAndPriceSortedStationery implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        char[] name1 = o1.getName().toLowerCase().toCharArray();
        char[] name2 = o2.getName().toLowerCase().toCharArray();
        int min_length = name1.length;
        if (name1.length > name2.length)
        {
            min_length = name2.length;

        }

        for (int i = 0; i < min_length - 1; )
        {
            if (name1[i] < name2[i])
                return -1;
            else if (name1[i] > name2[i])
                return 1;
            else
            {
                i++;
            }

        }
        if (name1 == name2) {
            int price1 = o1.getPrice();
            int price2 = o2.getPrice();
            if (price1 < price2)
                return -1;
            else if (price1 == price2)
                return 0;
            else
                return 1;

        }
        return 0;
    }
}
