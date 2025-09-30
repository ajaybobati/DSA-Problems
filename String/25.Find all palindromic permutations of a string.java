package String;

import java.util.*;

 class PalindromicPermutations {

    public static List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        // Count frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        char oddChar = 0;
        for (char c : freq.keySet()) {
            if (freq.get(c) % 2 != 0) {
                oddCount++;
                oddChar = c;
            }
        }

        if (oddCount > 1) return result;

        StringBuilder half = new StringBuilder();
        for (char c : freq.keySet()) {
            int count = freq.get(c) / 2;
            for (int i = 0; i < count; i++) {
                half.append(c);
            }
        }

        char[] halfArr = half.toString().toCharArray();
        Arrays.sort(halfArr);
        boolean[] used = new boolean[halfArr.length];
        backtrack(result, new StringBuilder(), halfArr, used, oddCount == 1 ? String.valueOf(oddChar) : "");

        return result;
    }

    private static void backtrack(List<String> result, StringBuilder path, char[] halfArr, boolean[] used, String mid) {
        if (path.length() == halfArr.length) {
            String half = path.toString();
            String palindrome = half + mid + new StringBuilder(half).reverse();
            result.add(palindrome);
            return;
        }

        for (int i = 0; i < halfArr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && halfArr[i] == halfArr[i - 1] && !used[i - 1]) continue; 

            used[i] = true;
            path.append(halfArr[i]);
            backtrack(result, path, halfArr, used, mid);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String input = "aabb";
        List<String> palindromes = generatePalindromes(input);
        System.out.println("Palindromic permutations: " + palindromes);

        input = "abc";
        palindromes = generatePalindromes(input);
        System.out.println("Palindromic permutations: " + palindromes);
    }
}

