package DynamicProgramming;


import java.util.HashMap;
import java.util.Map;
 
class Main
{
    public static int fib(int n, Map<Integer, Integer> lookup)
    {
        if (n <= 1) {
            return n;
        }
        if (!lookup.containsKey(n))
        {
            int val = fib(n - 1, lookup) + fib(n - 2, lookup);
            lookup.put(n, val);
        }
 
        return lookup.get(n);
    }
 
    public static void main(String[] args)
    {
        int n = 8;
        Map<Integer, Integer> lookup = new HashMap<>();
 
        System.out.println(fib(n, lookup));
    }
}



