package String;


class Main
{
    public static void balParenthesis(int n, String str, int open)
    {
        if ((n & 1) == 1 && open == 0) {
            return;
        }
        if (n == 0)
        {
            if (open == 0) {
                System.out.println(str);
            }
            return;
        }
 
        if (open > n) {
            return;
        }
        balParenthesis(n - 1, str + "(", open + 1);
 
        if (open > 0) {
            balParenthesis(n - 1, str + ")", open - 1);
        }
    }
 
    public static void main(String[] args)
    {
        int n = 6;
        balParenthesis(n, "", 0);
    }
}