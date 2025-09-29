package String;


class Main
{
    public static boolean check(String X, String Y)
    {
        if (X == null || Y == null) {
            return false;
        }
 
        if (X.length() != Y.length()) {
            return false;
        }
        for (int i = 0; i < X.length(); i++)
        {
            X = X.substring(1) + X.charAt(0);
 
            if (X.compareTo(Y) == 0) {
                return true;
            }
        }
        return false;
    }
 
    public static void main(String[] args)
    {
        String X = "ABCD";
        String Y = "DABC";
 
        if (check(X, Y)) {
            System.out.println("Given strings can be derived from each other");
        }
        else {
            System.out.println("Given strings cannot be derived from each other");
        }
    }
}
