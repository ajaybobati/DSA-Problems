package BinaryTree;
 class BitHacksLettersSimple {

    public static char toggleCase(char c) {
        return (char)(c ^ 32);
    }
    public static char toUpper(char c) {
        return (char)(c & ~32);
    }
    public static char toLower(char c) {
        return (char)(c | 32);
    }

    public static int letterIndex(char c) {
        return (c & 31) - 1;
    }
    public static int maskFromString(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                int idx = letterIndex(c);
                mask |= (1 << idx);
            }
        }
        return mask;
    }

    public static void main(String[] args) {
        char a = 'a', Z = 'Z';

        System.out.println("Toggle 'a' -> " + toggleCase(a));
        System.out.println("Toggle 'Z' -> " + toggleCase(Z));

        System.out.println("Upper of 'm' -> " + toUpper('m'));
        System.out.println("Lower of 'H' -> " + toLower('H'));

        System.out.println("Index of 'a' -> " + letterIndex('a'));
        System.out.println("Index of 'C' -> " + letterIndex('C'));

        String text = "The quick brown fox";
        int mask = maskFromString(text);
        System.out.println("Unique letters in text: " + Integer.bitCount(mask));
    }
}

