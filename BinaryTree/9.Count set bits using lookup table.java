package BinaryTree;

class CountSetBitsLookup {

    static int[] table = new int[256];

    static void initialize() {
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i >> 1];
        }
    }

    public static int countSetBits(int n) {
        return table[n & 0xff] +
               table[(n >> 8) & 0xff] +
               table[(n >> 16) & 0xff] +
               table[(n >> 24) & 0xff];
    }

    public static void main(String[] args) {
        initialize();

        int num = 29; 
        System.out.println("Number: " + num);
        System.out.println("Set bits: " + countSetBits(num));
    }
}

