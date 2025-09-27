package Stack;


import java.util.Stack;
 
class Main
{
    public static boolean hasDuplicateParenthesis(String exp)
    {
        if (exp == null || exp.length() <= 3) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
 
        for (char c: exp.toCharArray())
        {
            if (c != ')') {
                stack.push(c);
            }
            else {
                if (stack.peek() == '(') {
                    return true;
                }
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        return false;
    }
 
    public static void main(String[] args)
    {
        String exp = "((x+y))";    
 
        if (hasDuplicateParenthesis(exp)) {
            System.out.println("The expression has duplicate parenthesis.");
        }
        else {
            System.out.println("The expression does not have duplicate parenthesis");
        }
    }
}


