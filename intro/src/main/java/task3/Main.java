package task3;


import static task3.Solution.calculationOfFunctionF;
/* Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
Результат представить в виде таблицы, первый столбец которой – значения аргумента, второй -
соответствующие значения функции: F(x) = Math.tan(2 * x) - 3. */
public class Main {
    public static void main(String[] args) {
        int intervalBegin = 10;
        int intervalEnd = 33;
        int step = 3;
        calculationOfFunctionF(intervalBegin, intervalEnd, step);
    }
}
