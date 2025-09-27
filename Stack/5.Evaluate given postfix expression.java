package Stack;


import java.util.Stack;
 
class Main
{
    public static int evalPostfix(String exp)
    {
        if (exp == null || exp.length() == 0) {
            System.exit(-1);
        }
        Stack<Integer> stack = new Stack<>();
 
        for (char c: exp.toCharArray())
        {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            else {
                int x = stack.pop();
                int y = stack.pop();
 
                if (c == '+') {
                    stack.push(y + x);
                }
                else if (c == '-') {
                    stack.push(y - x);
                }
                else if (c == '*') {
                    stack.push(y * x);
                }
                else if (c == '/') {
                    stack.push(y / x);
                }
            }
        }
 
        return stack.pop();
    }
 
    public static void main(String[] args)
    {
        String exp = "138*+";
        System.out.println(evalPostfix(exp));
    }
}


