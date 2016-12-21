package task5;


class Solution {
    static void createMatrix(int width, int height)
    {
        for (int i = 0; i < height; )
        {
            for(int j = 0; j < width; j++)
            {
                if (j == i || j == width - 1 - i)
                {
                    System.out.print("1" + " ");
                }
                else
                {
                    System.out.print("0" + " ");
                }
            }
            System.out.println("");
            i++;
        }
    }
}
