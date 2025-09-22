package Array;


class bina
{
    private static int binarySearch(int[] A, int left, int right, int x)
    {
        if (left > right) {
            return -1;
        }
 
        int mid = (left + right) / 2;
 
        if (x == A[mid]) {
            return mid;
        }
        else if (x < A[mid]) {
            return binarySearch(A, left, mid - 1, x);
        }
        else {
            return binarySearch(A, mid + 1, right, x);
        }
    }
    public static int exponentialSearch(int[] A, int x)
    {
        if (A == null || A.length == 0) {
            return -1;
        }
 
        int bound = 1;
        while (bound < A.length && A[bound] < x) {
            bound *= 2;        
        }
 
        return binarySearch(A, bound/2, Integer.min(bound, A.length - 1), x);
    }
 
    public static void main(String[] args)
    {
        int[] A = {2, 5, 6, 8, 9, 10};
        int key = 9;
 
        int index = exponentialSearch(A, key);
 
        if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}

