package String;


import java.util.*;
 
 class Main  
{
    public static void findCombinations(String str, Deque<String> substring,
                                        Set<List<String>> combinations)
    {
        if (str.length() == 0) {
            combinations.add(new ArrayList<>(substring));
            return;
        }
        for (int i = 0; i < str.length(); i++)
        {
            substring.addLast(str.substring(0, i + 1));
            findCombinations(str.substring(i + 1), substring, combinations);
 
            substring.pollLast();
        }
    }
 
    public static Set<List<String>> findCombinations(String s)
    {
        Set<List<String>> combinations = new HashSet<>();
 
        if (s == null || s.length() == 0) {
            return combinations;
        }
 
        Deque<String> substring = new ArrayDeque<>();
 
        findCombinations(s, substring, combinations);
 
        return combinations;
    }
 
    public static void main(String[] args)
    {
        String str = "ABCD";
 
        Set<List<String>> combinations = findCombinations(str);
        System.out.println(combinations);
    }
}

