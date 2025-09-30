package String;


class Main
{
    public static String encode(String str)
    {
        String encoding = "";
 
        if (str == null) {
            return encoding;
        }
 
        int count;
 
        for (int i = 0; i < str.length(); i++)
        {
            
            count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))
            {
                count++;
                i++;
            }
 
            encoding += String.valueOf(count) + str.charAt(i);
        }
 
        return encoding;
    }
 
    public static void main(String[] args)
    {
        String str = "ABBCCCD";
 
        System.out.print(encode(str));
    }
}
