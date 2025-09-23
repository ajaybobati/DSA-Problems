package Array;
class cou
{
    public static int count(int[] S, int target)
    {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int result = 0;
        for (int c: S)
        {
            result += count(S, target - c);
        }
        return result;
    }
 
    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };

        int target = 4;
 
        System.out.println("The total number of ways to get the desired change is "
                + count(S, target));
    }
}