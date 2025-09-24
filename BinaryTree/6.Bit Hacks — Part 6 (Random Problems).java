package BinaryTree;

class Hacks4
{
    public static int findBits(int x, int y) {
        return (x | y) - (x & y);
    }
 
    public static void main(String[] args)
    {
        int x = 65;
        int y = 80;
 
        System.out.println("The first number in binary is " +
                        Integer.toBinaryString((x | y)));
 
        System.out.println("The second number in binary is " +
                        Integer.toBinaryString((x & y)));
 
        System.out.println("\nXOR is " + Integer.toBinaryString(findBits(x, y)));
    }
}

