package DynamicProgramming;


class Main
{
    public static int count(String X, String Y, int m, int n)
    {
        if (m == 1 && n == 1) {
            return (X.charAt(0) == Y.charAt(0)) ? 1: 0;
        }
        if (m == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n > m) {
            return 0;
        }
 
 
        return ((X.charAt(m - 1) == Y.charAt(n - 1)) ? count(X, Y, m - 1, n - 1) : 0)
                + count(X, Y, m - 1, n);
    }
 
    public static void main(String[] args)
    {
        String X = "subsequence";   // input string
        String Y = "sue";           // pattern
 
        System.out.print(count(X, Y, X.length(), Y.length()));
    }
}
