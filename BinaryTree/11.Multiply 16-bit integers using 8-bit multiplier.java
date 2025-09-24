package BinaryTree;
 class Multiply16BitUsing8Bit {
    static int multiply8bit(int a, int b) {
        return a * b; 
    }
    static int multiply16bit(int x, int y) {
        int xLow = x & 0xFF;
        int xHigh = (x >> 8) & 0xFF;

        int yLow = y & 0xFF;
        int yHigh = (y >> 8) & 0xFF;
        int p1 = multiply8bit(xLow, yLow);              
        int p2 = multiply8bit(xLow, yHigh) << 8;       
        int p3 = multiply8bit(xHigh, yLow) << 8;        
        int p4 = multiply8bit(xHigh, yHigh) << 16;     

        return p1 + p2 + p3 + p4;
    }

    public static void main(String[] args) {
        int a = 300;   
        int b = 200;   
        int result = multiply16bit(a, b);

        System.out.println(a + " * " + b + " = " + result);
    }
}

