package String;


class Main
{
    public static void recur(String currentNumber, int extraOnes, int remainingPlaces)
    {
        if (0 == remainingPlaces)
        {
            System.out.println(currentNumber);
            return;
        }
        recur(currentNumber + '1', extraOnes + 1, remainingPlaces - 1);
 
        if (0 < extraOnes) {
            recur(currentNumber + '0', extraOnes - 1, remainingPlaces - 1);
        }
    }
 
    public static void main(String[] args)
    {
        int numberOfDigits = 4;
        String str = "";
 
        recur(str, 0, numberOfDigits);
    }
}
