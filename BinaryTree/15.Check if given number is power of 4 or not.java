package BinaryTree;
class checkPow
{
    public static boolean checkPowerOf4(int n)
    {
        double i = Math.log(n) / Math.log(4);
 
        return i == Math.floor(i);
    }
 
    public static void main(String[] args)
    {
        int n = 256;
 
        if (checkPowerOf4(n)) {
            System.out.println(n + " is a power of 4");
        }
        else {
            System.out.println(n + " is not a power of 4");
        }
    }
}