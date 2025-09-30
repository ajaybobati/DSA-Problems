package DynamicProgramming;


class Main
{
    public static int LRSLength(String X, int m, int n)
    {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (X.charAt(m - 1) == X.charAt(n - 1) && m != n) {
            return LRSLength(X, m - 1, n - 1) + 1;
        }
        return Integer.max(LRSLength(X, m, n - 1),
                LRSLength(X, m - 1, n));
    }
 
    public static void main(String[] args)
    {
        String X = "ATACTCGGA";
        int m = X.length();
 
        System.out.println("The length of the longest repeating subsequence is " +
                LRSLength(X, m, m));
    }
}

