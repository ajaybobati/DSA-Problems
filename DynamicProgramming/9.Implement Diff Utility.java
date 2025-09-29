package DynamicProgramming;


class Main
{
    public static void diff(String X, String Y, int m, int n, int[][] lookup)
    {
        if (m > 0 && n > 0 && X.charAt(m - 1) == Y.charAt(n - 1))
        {
            diff(X, Y, m - 1, n - 1, lookup);
            System.out.print(" " + X.charAt(m - 1));
        }
        else if (n > 0 && (m == 0 || lookup[m][n - 1] >= lookup[m - 1][n]))
        {
            diff(X, Y, m, n - 1, lookup);
            System.out.print(" +" + Y.charAt(n - 1));
        }
 
        else if (m > 0 && (n == 0 || lookup[m][n - 1] < lookup[m - 1][n]))
        {
            diff(X, Y, m - 1, n, lookup);
            System.out.print(" -" + X.charAt(m - 1));
        }
    }
 
    public static int[][] findLCS(String X, String Y, int m, int n)
    {
        int[][] lookup = new int[X.length() + 1][Y.length() + 1];
        for (int i = 0; i <= m; i++) {
            lookup[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            lookup[0][j] = 0;
        }
 
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
 
        return lookup;
    }
    public static void main(String[] args)
    {
        String X = "ABCDFGHJQZ";
        String Y = "ABCDEFGIJKRXYZ";
 
        int[][] lookup = findLCS(X, Y, X.length(), Y.length());
 
        diff(X, Y, X.length(), Y.length(), lookup);
    }
}
