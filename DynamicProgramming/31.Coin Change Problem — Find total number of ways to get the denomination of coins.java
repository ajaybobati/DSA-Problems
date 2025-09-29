package DynamicProgramming;


class Main
{
    public static int count(int[] S, int n, int target)
    {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || n < 0) {
            return 0;
        }
 
        int incl = count(S, n, target - S[n]);
 
        int excl = count(S, n - 1, target);
 
        return incl + excl;
    }
 
    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };
 
        int target = 4;
 
        System.out.print("The total number of ways to get the desired change is "
                                + count(S, S.length - 1, target));
    }
}

