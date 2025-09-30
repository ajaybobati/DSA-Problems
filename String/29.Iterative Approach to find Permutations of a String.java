package String;

import java.util.*;

 class IterativePermutations {
    private static boolean nextPermutation(char[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) return false; 

        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);

        reverse(arr, i + 1, n - 1);

        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public static List<String> getPermutations(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr); 

        result.add(new String(arr));
        while (nextPermutation(arr)) {
            result.add(new String(arr));
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ABC";
        List<String> permutations = getPermutations(str);
        System.out.println("All permutations:");
        for (String p : permutations) {
            System.out.println(p);
        }
    }
}

