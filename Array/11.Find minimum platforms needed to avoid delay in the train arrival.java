package Array;

import java.util.Arrays;
 
class findMinPla
{
    
    public static int findMinPlatforms(double[] arrival, double[] departure)
    {
        Arrays.sort(arrival);
 

        int count = 0;

        int platforms = 0;
        int i = 0, j = 0;
        while (i < arrival.length)
        {
            if (arrival[i] < departure[j])
            {
                platforms = Integer.max(platforms, ++count);
 
                i++;
            }

            else {
                count--;
                j++;
            }
        }
 
        return platforms;
    }
 
    public static void main(String[] args)
    {
        double[] arrival = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 };
        double[] departure = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 };
 
        System.out.print("The minimum platforms needed is "
                    + findMinPlatforms(arrival, departure));
    }
}