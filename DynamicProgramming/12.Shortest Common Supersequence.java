package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
 
class Main
{
    public static int LCSLength(String X, String Y, int m, int n,
                                Map<String, Integer> lookup)
    {
        if (m == 0 || n == 0) {
            return 0;
        }
 
        String key = m + "|" + n;
        if (!lookup.containsKey(key))
        {
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);
            }
            else {
                int max = Integer.max(LCSLength(X, Y, m, n - 1, lookup),
                                    LCSLength(X, Y, m - 1, n, lookup));
                lookup.put(key, max);
            }
        }
        return lookup.get(key);
    }
 
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";
 
        int m = X.length(), n = Y.length();
        Map<String, Integer> lookup = new HashMap<>();
 
        int len = LCSLength(X, Y, m, n, lookup);
 
        System.out.println("The length of the shortest common supersequence is "
                        + (m + n - len));
    }
}

