package BinaryTree;

class positionOfRightm
{
    public static int positionOfRightmostSetBit(int n)
    {
        if ((n & 1) != 0) {
            return 1;
        }
        n = n ^ (n & (n - 1));
 
        int pos = 0;
        while (n != 0)
        {
            n = n >> 1;
            pos++;
        }
 
        return pos;
    }
 
    public static void main(String[] args)
    {
        int n = 20;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("The position of the rightmost set bit is " +
                            positionOfRightmostSetBit(n));
    }
}

