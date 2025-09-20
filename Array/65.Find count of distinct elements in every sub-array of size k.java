package Array;
class findDisti
{ 

    public static void findDistinctCount(int[] arr, int k)
    {
        for (int x = 0; x <= arr.length - k; x++)
        {
            int distinct = 0;
 
            for (int i = x; i < x + k; i++)
            {
                distinct++;
 
                for (int j = x; j < i; j++)
                {
                    if (arr[i] == arr[j])
                    {
                        distinct--;
                        break;
                    }
                }
            }
 
            System.out.printf("The count of distinct elements in subarray [%d, %d]"
                                + " is %d\n", x, x + k - 1, distinct);
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 2, 1, 2, 3, 2, 1, 4, 5 };
        int k = 5;
 
        findDistinctCount(arr, k);
    }
}


