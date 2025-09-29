package DynamicProgramming;


class Main
{
    public static int rodCut(int[] price, int n)
    {
        if (n == 0) {
            return 0;
        }
 
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++)
        {
            int cost = price[i - 1] + rodCut(price, n - i);
 
            if (cost > maxValue) {
                maxValue = cost;
            }
        }
 
        return maxValue;
    }
 
    public static void main(String[] args)
    {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
 
        int n = 4;
 
        System.out.println("Profit is " + rodCut(price, n));
    }
}

