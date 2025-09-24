package BinaryTree;

class toBinaryStr
{
    public static String toBinaryString(int n)
    {
        return String.format("%32s", Integer.toBinaryString(n))
                    .replaceAll(" ", "0");
    }
    public static int shift(int n, int k, boolean isLeftShift)
    {
        if (isLeftShift) {
            return (n << k) | (n >> (Integer.SIZE - k));
        }
 
        return (n >> k) | (n << (Integer.SIZE - k));
    }
 
    public static void main(String[] args)
    {
        int n = 127;
        int shift = 3;
 
        System.out.println("No Shift    " + toBinaryString(n));
        System.out.println("Left Shift  " + toBinaryString(shift(n, shift, true)));
        System.out.println("Right Shift " + toBinaryString(shift(n, shift, false)));
    }
}