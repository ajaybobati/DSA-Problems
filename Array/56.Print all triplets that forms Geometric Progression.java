package Array;

class findAllTri
{
    public static void findAllTriplets(int[] A)
    {
        if (A.length < 3) {
            return;
        }
        for (int j = 1; j < A.length - 1; j++)
        {
            int i = j - 1, k = j + 1;
 
            while (true)
            {
                while (i >= 0 && k <= A.length - 1 &&
                        (A[j] % A[i] == 0) && (A[k] % A[j] == 0) &&
                        (A[j] / A[i] == A[k] / A[j]))
                {
                    System.out.println(A[i] + " " + A[j] + " " + A[k]);
 
                    k++;
                    i--;
                }
 
                if (i < 0 || k >= A.length) {
                    break;
                }
                if (A[j] % A[i] == 0 && A[k] % A[j] == 0)
                {
                    if (A[j] / A[i] < A[k] / A[j]) {
                        i--;
                    }
                    else {
                        k++;
                    }
                }
                else if (A[j] % A[i] == 0) {
                    k++;
                }
                else {
                    i--;
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 6, 10, 18, 54 };
 
        findAllTriplets(A);
    }
}

