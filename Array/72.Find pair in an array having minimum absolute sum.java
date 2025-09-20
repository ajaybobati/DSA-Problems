package Array;

class finds
{
    public static void findPair(int[] A)
    {
        if (A.length < 2) {
            return;
        }
        int low = 0;
        int high = A.length - 1;
 
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
 
        while (low < high)
        {
            if (Math.abs(A[high] + A[low]) < min)
            {
                min = Math.abs(A[high] + A[low]);
                i = low;
                j = high;
            }
 
            if (min == 0) {
                break;
            }
 
            if (A[high] + A[low] < 0) {
                low++;
            }
            else {
                high--;
            }
        }
 
        // print the pair
        System.out.print("Pair found (" + A[i] + ", " + A[j] + ")");
    }
 
    public static void main(String[] args)
    {
        int[] A = { -6, -5, -3, 0, 2, 4, 9 };
 
        findPair(A);
    }
}

