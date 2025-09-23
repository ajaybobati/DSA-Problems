package Array;

class printAllSubst
{
    public static void printAllSubstrings(String str)
    {
        int n = str.length();
 
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++) {
                System.out.print("'" + str.substring(i, j + 1) + "', ");
            }
        }
    }
 
    public static void main(String[] args)
    {
        String str = "techie";
        printAllSubstrings(str);
    }
}