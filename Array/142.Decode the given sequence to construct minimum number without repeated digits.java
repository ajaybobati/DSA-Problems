package Array;
import java.util.Stack;
 
class Decodethe
{
    public static String decode(String seq)
    {
        if (seq == null || seq.length() == 0) {
            return seq;
        }
        StringBuilder result = new StringBuilder();
 
        Stack<Integer> stack = new Stack<>();
 
        for (int i = 0; i <= seq.length(); i++)
        {
            stack.push(i + 1);
 
            if (i == seq.length() || seq.charAt(i) == 'I')
            {
                while (!stack.empty())
                {
                    result.append(stack.pop());
                }
            }
        }
 
        return result.toString();
    }
 
    public static void main(String[] args)
    {
        String seq = "IDIDII";
 
        System.out.println("The minimum number is " + decode(seq));
    }
}

