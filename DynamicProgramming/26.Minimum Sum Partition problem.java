package DynamicProgramming;

class Main
{
    public static int findMinAbsDiff(int[] S, int n, int S1, int S2)
    {
        if (n < 0) {
            return Math.abs(S1 - S2);
        }
 
        int inc = findMinAbsDiff(S, n - 1, S1 + S[n], S2);
 
        int exc = findMinAbsDiff(S, n - 1, S1, S2 + S[n]);
 
        return Integer.min(inc, exc);
    }
 
    public static void main(String[] args)
    {
        int[] S = { 10, 20, 15, 5, 25 };
 
        System.out.println("The minimum difference is "
                + findMinAbsDiff(S, S.length - 1, 0, 0));
    }
}
