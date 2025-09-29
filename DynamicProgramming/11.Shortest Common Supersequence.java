package DynamicProgramming;


class Main
{
    public static String SCS(String X, String Y, int m, int n, int[][] lookup)
    {
        if (m == 0) {
            return Y.substring(0, n);
        }
 
        if (n == 0) {
            return X.substring(0, m);
        }
 
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return SCS(X, Y, m - 1, n - 1, lookup) + X.charAt(m - 1);
        }
        else {
 
 
            if (lookup[m - 1][n] < lookup[m][n - 1]) {
                return SCS(X, Y, m - 1, n, lookup) + X.charAt(m - 1);
            }
            else {
                return SCS(X, Y, m, n - 1, lookup) + Y.charAt(n - 1);
            }
        }
    }
    public static void SCSLength(String X, String Y, int m, int n, int[][] lookup)
    {
        for (int i = 0; i <= m; i++) {
            lookup[i][0] = i;
        }
 
        for (int j = 0; j <= n; j++) {
            lookup[0][j] = j;
        }
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }
                else {
                    lookup[i][j] = Integer.min(lookup[i - 1][j] + 1, lookup[i][j - 1] + 1);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";
 
        int m = X.length(), n = Y.length();
 
        int[][] lookup = new int[m + 1][n + 1];
        SCSLength(X, Y, m, n, lookup);
        System.out.print("The shortest common supersequence of " + X +
                " and " + Y + " is " + SCS(X, Y, m, n, lookup));
    }
}

