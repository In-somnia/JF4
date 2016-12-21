package task5;


import static task5.Solution.createMatrix;
/* Получить матрицу:
 * 1 0 0 ... 0 0 1
 * 0 1 0 ... 0 1 0
 * 0 0 1 ... 1 0 0
 * . . . ... . . .
 * 0 1 0 ... 0 1 0
 * 1 0 0 ... 0 0 1 */
public class Main {
    public static void main(String[] args)
    {
        createMatrix(7, 7);
    }
}
