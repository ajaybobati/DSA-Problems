package String;


class Main
{
    public static void findNdigitNums(String result, int n, int target)
    {
        if (n > 0 && target >= 0)
        {
            char d = '0';
            if (result.equals("")) {   
                d = '1';
            }
            while (d <= '9')
            {
                findNdigitNums(result + d, n - 1, target - (d - '0'));
                d++;
            }
        }
        else if (n == 0 && target == 0) {
            System.out.print(result + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int n = 3;   
        int target = 6;   
 
        String result = "";
        findNdigitNums(result, n, target);
    }
}