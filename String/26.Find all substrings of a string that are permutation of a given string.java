package String;
import java.util.*;

 class FindAllAnagrams {
    
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        int[] pCount = new int[26]; 
        int[] sCount = new int[26]; 
        
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        int window = p.length();
        
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            
            if (i >= window) {
                sCount[s.charAt(i - window) - 'a']--;
            }
            
            if (Arrays.equals(pCount, sCount)) {
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        
        List<Integer> indices = findAnagrams(s, p);
        System.out.println("Starting indices of anagram substrings: " + indices);
        
        // Extract actual substrings
        for (int idx : indices) {
            System.out.println("Substring: " + s.substring(idx, idx + p.length()));
        }
    }
}
