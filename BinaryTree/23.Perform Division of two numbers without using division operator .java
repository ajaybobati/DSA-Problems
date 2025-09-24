package BinaryTree;

class divi
{
    public static int divide(int x, int y)
    {
        if (y == 0)
        {
            System.out.printf("Error!! Divisible by 0");
            System.exit(-1);
        }
 
        int sign = 1;
        if (x * y < 0) {
            sign = -1;
        }
        x = Math.abs(x);
        y = Math.abs(y);
 
        int mask = 1;
        int quotient = 0;
 
        while (y <= x)
        {
            y <<= 1;
            mask <<= 1;
        }
 
        while (mask > 1)
        {
            y >>= 1;
            mask >>= 1;
            if (x >= y)
            {
                x -= y;
                quotient |= mask;
            }
        }
 
        System.out.printf("The remainder is %d\n", x);
        return sign * quotient;
    }
 
    public static void main(String[] args)
    {
        int dividend = 22;
        int divisor = -7;
 
        System.out.printf("The quotient is %d\n", divide(dividend, divisor));
    }
}

