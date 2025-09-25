package Heap;


class checkMi
{
    public static boolean checkMinHeap(int[] A, int i)
    {
        if (2*i + 2 > A.length) {
            return true;
        }
 
        boolean left = (A[i] <= A[2*i + 1]) && checkMinHeap(A, 2*i + 1);
 
        boolean right = (2*i + 2 == A.length) ||
                        (A[i] <= A[2*i + 2] && checkMinHeap(A, 2*i + 2));
 
        return left && right;
    }
 
    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 4, 5, 6};
        int index = 0;
 
        if (checkMinHeap(A, index)) {
            System.out.println("The given array is a min-heap");
        }
        else {
            System.out.println("The given array is not a min-heap");
        }
    }
}

