package BinaryTree;

class toBinaryStr
{
    public static String toBinaryString(int n)
    {
        return String.format("%8s", Integer.toBinaryString(n))
                    .replaceAll(" ", "0");
    }
 
    public static int swap(int n, int p, int q, int b)
    {
        int x = ((n >> p) ^ (n >> q));
 
        x = x & ((1 << b) - 1);
 
        return n ^ ((x << p) | (x << q));
    }
 
    public static void main(String[] args)
    {
        int n = 15;
        int p = 2, q = 5;   
        int b = 2;          
 
        System.out.println(n + " in binary is " + toBinaryString(n));
        n = swap (n, p, q, b);
        System.out.println(n + " in binary is " + toBinaryString(n));
    }
}

