package task4;


import static task4.Solution.additionOfOppositeArrayIndexes;
import static task4.Solution.maxNumber;
/* Даны действительные числа a1, a2 … an. Найти max(a1 + a2n, a2 + a2n - 1, ... , an + an+1). */
public class Main {
    public static void main(String[] args) {
        int[] initialArray = {4, 12, 35, 16, 27, 2, 75, 9};
        int[] arrayOfAddedNumbers = additionOfOppositeArrayIndexes(initialArray);
        System.out.println("Максимальное значение последовательности: " + maxNumber(arrayOfAddedNumbers));
    }
}
