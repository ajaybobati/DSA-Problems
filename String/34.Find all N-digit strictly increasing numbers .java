package String;


class Main
{
    public static void printStrictlyInc(String result, int n, char prev)
    {
        if (n == 0)
        {
            System.out.print(result + " ");
            return;
        }
        for (char ch = (char)(prev + 1); ch <= '9'; ch++) {
            printStrictlyInc(result + ch, n - 1, ch);
        }
    }
 
    public static void main(String[] args)
    {
        int n = 7;
 
        String result = "";
        printStrictlyInc(result, n, '0');
    }
}
