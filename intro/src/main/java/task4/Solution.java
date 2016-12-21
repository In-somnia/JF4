package task4;


class Solution {
    static int[] additionOfOppositeArrayIndexes(int[] array)
    {
        int[] arrayOfAddedIndexes = new int[array.length / 2];
        int n = (array.length) / 2;

        for (int i = 0; i <array.length; i++)
        {
            int a = array[i] + array[(2 * n) - 1 - i];
            arrayOfAddedIndexes[i] = a;
            if (i == (n - 1))
            {
                a = array[n - 1] + array[n];
                arrayOfAddedIndexes[i] = a;
                break;
            }
        }
        return arrayOfAddedIndexes;
    }
    static int maxNumber(int[] array)
    {
        int max = 0;
        for (int i : array)
        {
            if(i > max)
            {
                max = i;
            }
        }
        return max;
    }
}
