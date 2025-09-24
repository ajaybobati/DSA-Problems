package BinaryTree;

class powere
{
    public static long power(int x, int n)
    {
        long pow = 1L;
        for (int i = 0; i < n; i++) {
            pow = pow * x;
        }
 
        return pow;
    }
 
    public static void main(String[] args)
    {
        int x = -2;
        int n = 10;
 
        System.out.println("pow(" + x + ", " + n + ") = " + power(x, n));
    }
}

