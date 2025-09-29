package String;


import java.util.Random;
 
class Main
{
    public static String getColumnName(int n)
    {
        StringBuilder result = new StringBuilder();
 
        while (n > 0)
        {
            int index = (n - 1) % 26;
            result.append((char)(index + 'A'));
            n = (n - 1) / 26;
        }
 
        return result.reverse().toString();
    }
 
    public static void main(String[] args)
    {
       
        for (int i = 1; i <= 10; i++)
        {
            int r = new Random().nextInt(1000) + 1;
            System.out.println(r + " — " + getColumnName(r));
        }
    }
}