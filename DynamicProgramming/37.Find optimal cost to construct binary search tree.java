package DynamicProgramming;


class Main
{
    public static int findOptimalCost(int[] freq, int i, int j, int level)
    {
        if (j < i) {
            return 0;
        }
 
        int optimalCost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++)
        {
            int leftOptimalCost = findOptimalCost(freq, i, k - 1, level + 1);
 
            int rightOptimalCost = findOptimalCost(freq, k + 1, j, level + 1);
 
            int cost = freq[k] * level + leftOptimalCost + rightOptimalCost;
 
            optimalCost = Integer.min(optimalCost, cost);
        }
 
        return optimalCost;
    }
 
    public static void main(String[] args)
    {
        int[] freq = { 25, 10, 20 };
 
        System.out.println("The optimal cost of constructing BST is "
                        + findOptimalCost(freq, 0, freq.length - 1, 1));
    }
}
