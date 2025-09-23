package Array;
class conver
{
    public static void convert(int[] arr)
    {
        arr[0] = arr[1] = arr[0] & arr[1];
    }
 
    public static void main(String[] args)
    {
        int[] first = { 0, 1 };
        convert(first);
        System.out.println(first[0] + " " + first[1]);
 
        int[] second = { 1, 0 };
        convert(second);
        System.out.println(second[0] + " " + second[1]);
 
        int[] third = { 0, 0 };
        convert(third);
        System.out.println(third[0] + " " + third[1]);
    }
}

