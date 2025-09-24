package BinaryTree;


class indSq
{
    public static int findSquare(int num)
    {
        int odd = 1;
        int sq = 0;
 
        num = Math.abs(num);
 
        while (num-- > 0)
        {
            sq = sq + odd;
            odd = odd + 2;
        }
 
        return sq;
    }
 
    public static void main(String[] args)
    {
        System.out.println(findSquare(8));
        System.out.println(findSquare(-4));
    }
}

