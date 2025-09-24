package BinaryTree;
class checkPow
{
    public static boolean checkPowerOf8(int n)
    {
        double i = Math.log(n) / Math.log(8);
 
        return i - Math.floor(i) < 0.000001;
    }
 
    public static void main(String[] args)
    {
        int n = 512*64;
 
        if (checkPowerOf8(n)) {
            System.out.println(n + " is a power of 8");
        }
        else {
            System.out.println(n + " is not a power of 8");
        }
    }
}


