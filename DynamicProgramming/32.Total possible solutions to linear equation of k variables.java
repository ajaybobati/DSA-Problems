package DynamicProgramming;

class Main
{
    public static int count(int[] coeff, int k, int rhs)
    {
        if (rhs == 0) {
            return 1;
        }
 
        if (rhs < 0 || k < 0) {
            return 0;
        }
 
        int include = count(coeff, k, rhs - coeff[k]);
 
        int exclude = count(coeff, k - 1, rhs);
 
        return include + exclude;
    }
 
    public static void main (String[] args)
    {
       
        int[] coeff = { 1, 2, 3 };
        int k = coeff.length;
 
        int rhs = 4;
 
        System.out.println("The total number of solutions is " +
            count(coeff, k - 1, rhs));
    }
}


