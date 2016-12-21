package task2;


import java.io.*;
import static java.lang.Math.pow;
class Solution {
    static void minIndex(double[] array) throws IOException
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Задайте условие е(введите дробное число)");
        double e = Double.parseDouble(reader.readLine());
        int minIndex; //Наименьший номер элемента последовательности, для которого выполняется условие.
        for (int i = 1; i < array.length; i++)
        {
            double a = (1 / pow((i + 1), 2));

            if(!checkCondition(a, e))
            {
                array[i] = a;
            }
            else
            {
                minIndex = i;
                System.out.println("Наименьший номер элемента последовательности, для которого выполняется условие М: " + minIndex);
                System.out.println("Все элементы а(i), для которых условие М не выполняется: ");
                for(int j = 1; j < minIndex; j++)
                {
                    System.out.println(array[j]);
                }
                break;
            }
        }
    }
    private static boolean checkCondition(double a, double e)
    {
        boolean M = false;
        if (a < e)
        {
            M = true;
        }
        return M;
    }
}
