package DynamicProgramming;


class Main
{
    public static String LCS(String X, String Y, int m, int n, int[][] lookup)
    {
        if (m == 0 || n == 0) {
            return new String();
        }
 
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            return LCS(X, Y, m - 1, n - 1, lookup) + X.charAt(m - 1);
        }
 
 
        if (lookup[m - 1][n] > lookup[m][n - 1]) {
            return LCS(X, Y, m - 1, n, lookup);
        }
        else {
            return LCS(X, Y, m, n - 1, lookup);
        }
    }
    public static void LCSLength(String X, String Y, int m, int n, int[][] lookup)
    {
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }
                else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        String X = "XMJYAUZ", Y = "MZJAWXU";
        int m = X.length(), n = Y.length();
        int[][] lookup = new int[m + 1][n + 1];
 
        LCSLength(X, Y, m, n, lookup);
        System.out.println(LCS(X, Y, m, n, lookup));
    }
}
