package BinaryTree;

class Brian 
{
    public static int countSetBits(int n)
    {
        int count = 0;
        for (int i = 0; i < 32; i++)
        {
            count += (n & 1);  
            n >>= 1;
        }
 
        return count;
    }
 
    public static void main(String[] args)
    {
        int n = 16;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("The total number of set bits in " + n + " is " +
                    countSetBits(n));
    }
}


