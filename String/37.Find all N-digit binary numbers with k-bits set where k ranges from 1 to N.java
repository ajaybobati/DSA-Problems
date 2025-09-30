package String;

 class BinaryWithKBits {

    private static void generate(String prefix, int n, int k, int ones) {
        if (prefix.length() == n) {
            if (ones == k) {
                System.out.println(prefix);
            }
            return;
        }
        generate(prefix + "0", n, k, ones);

        generate(prefix + "1", n, k, ones + 1);
    }

    public static void main(String[] args) {
        int n = 3; 
        
        for (int k = 1; k <= n; k++) {
            System.out.println("n = " + n + ", k = " + k + ":");
            generate("", n, k, 0);
            System.out.println();
        }
    }
}
