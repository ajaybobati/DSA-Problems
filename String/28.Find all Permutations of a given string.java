package String;

 class StringPermutations {

    public static void permute(char[] str, int l, int r) {
        if (l == r) {
            System.out.println(String.valueOf(str));
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(str, l, i);
            permute(str, l + 1, r);
            swap(str, l, i); 
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        String s = "ABC";
        permute(s.toCharArray(), 0, s.length() - 1);
    }
}
