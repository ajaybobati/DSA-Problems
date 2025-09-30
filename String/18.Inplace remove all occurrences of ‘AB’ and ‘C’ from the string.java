package String;


class Main
{
    public static String remove(String str)
    {
        // base case
        if (str == null) {
            return null;
        }
 
        char[] chars = str.toCharArray();
 
        int i = 0, k = 0;
        while (i < str.length())
        {
            if (chars[i] == 'B' && (k > 0 && chars[k - 1] == 'A'))
            {
                --k;
                ++i;
            }
            else if (chars[i] == 'C') {
                ++i;
            }
            else {
                chars[k++] = chars[i++];
            }
        }
 
        return new String(chars).substring(0, k);
    }
 
    public static void main(String[] args)
    {
        String str = "ABCACBCAABB";
 
        str = remove(str);
        System.out.printf("The string after removal of 'AB' and 'C' is '%s'", str);
    }
}

