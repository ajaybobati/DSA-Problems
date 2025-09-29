package DynamicProgramming;


class Main
{
    public static int findMaxProfit(int n)
    {
        if (n <= 1) {
            return n;
        }
        int maxValue = n;
 
        for (int i = 1; i <= n; i++) {
            maxValue = Integer.max(maxValue, i * findMaxProfit(n - i));
        }
 
        return maxValue;
    }
 
    public static void main(String[] args)
    {
        int n = 15;    
        System.out.println("The maximum profit is " + findMaxProfit(n));
    }
}


