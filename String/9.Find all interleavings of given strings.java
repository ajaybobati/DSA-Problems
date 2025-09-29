package String;

import java.util.HashSet;
import java.util.Set;
 
class Main
{
    public static void findInterleavings(String curr, String X, String Y,
                                         Set<String> interleavings)
    {
        if (X.length() == 0 && Y.length() == 0)
        {
            interleavings.add(curr);
            return;
        }
        if (X.length() > 0) {
            findInterleavings(curr + X.charAt(0), X.substring(1), Y, interleavings);
        }
 
 
        if (Y.length() > 0) {
            findInterleavings(curr + Y.charAt(0), X, Y.substring(1), interleavings);
        }
    }
 
    public static Set<String> findInterleavings(String X, String Y)
    {
        Set<String> interleavings = new HashSet<>();
 
        if (X.length() == 0 && Y.length() == 0) {
            return interleavings;
        }
 
        findInterleavings("", X, Y, interleavings);
        return interleavings;
    }
 
    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "ACB";
        Set<String> interleavings = findInterleavings(X, Y);
        System.out.println(interleavings);
    }
}

