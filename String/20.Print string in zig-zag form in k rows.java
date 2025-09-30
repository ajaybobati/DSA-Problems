package String;


class Main
{
    public static void printZigZag(String str, int k)
    {
        if (str == null || k == 0) {
            return;
        }
        if (k == 1)
        {
            System.out.print(str);
            return;
        }
        for (int i = 0; i < str.length(); i += (k-1)*2) {
            System.out.print(str.charAt(i));
        }
        for (int j = 1; j < k - 1; j++)
        {
            boolean down = true;
            for (int i = j; i < str.length();)
            {
                System.out.print(str.charAt(i));
                if (down) {    
                    i += (k - j - 1) * 2;
                }
                else {       
                    i += (k - 1) * 2 - (k - j - 1) * 2;
                }
 
                down = !down;  
            }
        }
        for (int i = k - 1; i < str.length(); i += (k - 1) * 2) {
            System.out.print(str.charAt(i));
        }
    }
 
    public static void main(String[] args)
    {
        String str = "THISPROBLEMISAWESOME";
        int k = 4;
 
        printZigZag(str, k);
    }
}