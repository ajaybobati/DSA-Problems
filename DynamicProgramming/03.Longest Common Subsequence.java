package DynamicProgramming;


class Main
{
    public static int LCSLength(String X, String Y)
    {
        int m = X.length(), n = Y.length();
 
        int[] curr = new int[n + 1];
        int[] prev = new int[n + 1];
 
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i > 0 && j > 0)
                {
                    if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        curr[j] = prev[j - 1] + 1;
                    }
                    else {
                        curr[j] = Integer.max(prev[j], curr[j - 1]);
                    }
                }
            }
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }
        return curr[n];
    }
 
    public static void main(String[] args)
    {
        String X = "XMJYAUZ", Y = "MZJAWXU";
 
        System.out.println("The length of the LCS is " + LCSLength(X, Y));
    }
}

