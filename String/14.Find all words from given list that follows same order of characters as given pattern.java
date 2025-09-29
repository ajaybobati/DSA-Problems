package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class Main
{
    public static void patternMatch(List<String> words, String pattern)
    {
        if (words == null || pattern == null) {
            return;
        }
 
        int len = pattern.length();
 
        for (String word: words)
        {
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            if (word.length() == len)
            {
                int i;
                for (i = 0; i < len; i++)
                {
                    char w = word.charAt(i);
                    char p = pattern.charAt(i);
 
                    var prev = map1.putIfAbsent(w, p);
 
                    if (prev != null && map1.get(w) != p) {
                        break;
                    }
                    prev = map2.putIfAbsent(p, w);
                    if (prev != null && map2.get(p) != w) {
                        break;
                    }
                }
 
                if (i == len) {
                    System.out.println(word);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("leet", "abcd", "loot", "geek",
                "cool", "for", "peer", "dear", "seed",
                "meet", "noon", "otto", "mess", "loss");
 
        String pattern = "moon";
 
        patternMatch(words, pattern);
    }
}

