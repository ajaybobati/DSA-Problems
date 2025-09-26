package Greedy;

class Main
{
    private static int findOverlappingPair(String s1, String s2, StringBuilder sb)
    {
        int max = Integer.MIN_VALUE;
 
        int n = Integer.min(s1.length(), s2.length());
 
        for (int i = 1; i <= n; i++)
        {
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i)))
            {
                if (max < i)
                {
                    max = i;
                    sb.setLength(0);
                    sb.append(s1).append(s2.substring(i));
                }
            }
        }
 
        for (int i = 1; i <= n; i++)
        {
            if (s1.substring(0, i).equals(s2.substring(s2.length() - i)))
            {
                if (max < i)
                {
                    max = i;
                    sb.setLength(0);
                    sb.append(s2).append(s1.substring(i));
                }
            }
        }
 
        return max;
    }
 
    public static String findShortestSuperstring(String[] words)
    {
        int n = words.length;
        while (n != 1)
        {
            int max = Integer.MIN_VALUE;
            int p = -1, q = -1;
            String res_str = "";
 
            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    StringBuilder sb = new StringBuilder();
 
                    int r = findOverlappingPair(words[i], words[j], sb);
 
                    if (max < r)
                    {
                        max = r;
                        res_str = sb.toString();
                        p = i;
                        q = j;
                    }
                }
            }
 
            n--;
            if (max == Integer.MIN_VALUE) {
                words[0] = words[0] + words[n];
            }
            else {
                words[p] = res_str;
 
                words[q] = words[n];
            }
        }
 
        return words[0];
    }
 
    public static void main(String[] args)
    {
        String[] words = { "CATGC", "CTAAGT", "GCTA", "TTCA", "ATGCATC" };
 
        System.out.println("The shortest superstring is "
                + findShortestSuperstring(words));
    }
}
