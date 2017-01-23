package task4;

import task3.Stationery;
import java.util.Comparator;


public class NameSortedStationery implements Comparator<Stationery> {
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
        return 0;
    }
}
