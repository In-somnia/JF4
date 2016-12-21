package task2;


import java.io.*;
import static task2.Solution.minIndex;
/* Найти наименьший номер элемента последовательности, для которого выполняется условие M.
Вывести на экран этот номер и все элементы a(i), где i = 1, 2, ..., n. a(n) = (1 / pow((n + 1), 2)), M: a(n) < e. */
public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Укажите длину последовательности n");
        int n = Integer.parseInt(reader.readLine());
        double[] array = new double[n];
        minIndex(array);
    }
}
