package BinaryTree;


class Main
{
    public static int findPreviousPowerOf2(int n)
    {
        while ((n & n - 1) != 0) {
            n = n & n - 1;     
        }
 
        return n;
    }
 
    public static void main(String[] args)
    {
        int n = 128;
 
        System.out.println("The previous power of 2 is " + findPreviousPowerOf2(n));
    }
}