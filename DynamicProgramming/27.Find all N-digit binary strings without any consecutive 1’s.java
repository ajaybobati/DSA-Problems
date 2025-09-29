package DynamicProgramming;


class Main
{
    public static int countStrings(int n, int lastDigit)
    {
        if (n == 0) {
            return 0;
        }
 
        if (n == 1) {
            return (lastDigit == 1) ? 1: 2;
        }
        if (lastDigit == 0) {
            return countStrings(n - 1, 0) + countStrings(n - 1, 1);
        }
        else {
            return countStrings(n - 1, 0);
        }
    }
 
    public static void main(String[] args)
    {
        int n = 5;
 
        System.out.println("The total number of " + n + "–digit binary numbers " +
                "without any consecutive 1's are " + countStrings(n, 0));
    }
}


