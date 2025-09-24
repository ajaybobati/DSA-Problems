package BinaryTree;
class hacks2
{
    public static int turnOffKthBit(int n, int k) {
        return n & ~(1 << (k - 1));
    }
 
    public static void main(String[] args)
    {
        int n = 20;
        int k = 3;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Turning k'th bit off…");
        n = turnOffKthBit(n, k);
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
    }
}