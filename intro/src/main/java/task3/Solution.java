package task3;


class Solution {
    static void calculationOfFunctionF(int a, int b, int c)
    {
        for (int x = a; x <= b; x = x + c)
        {
            double F = Math.tan(2 * x) - 3;
            System.out.println("Значение аргумента: " + x + ", Значение функции F(x): " + F);
        }
    }
}
