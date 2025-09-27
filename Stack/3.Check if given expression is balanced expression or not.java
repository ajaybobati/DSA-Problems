package Stack;

import java.util.Stack;
 
class Main
{
    // Function to check if the given expression is balanced or not
    public static boolean isBalanced(String exp)
    {
        // base case: length of the expression must be even
        if (exp == null || exp.length() % 2 == 1) {
            return false;
        }
 
        // take an empty stack of characters
        Stack<Character> stack = new Stack<>();
 
        // traverse the input expression
        for (char c: exp.toCharArray())
        {
            // if the current character in the expression is an opening brace,
            // push it into the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
 
            // if the current character in the expression is a closing brace
            if (c == ')' || c == '}' || c == ']')
            {
                if (stack.empty()) {
                    return false;
                }
                Character top = stack.pop();
                if ((top == '(' && c != ')') || (top == '{' && c != '}')
                        || (top == '[' && c != ']')) {
                    return false;
                }
            }
        }
 
        return stack.empty();
    }
 
    public static void main(String[] args)
    {
        String exp = "{()}[{}]";
 
        if (isBalanced(exp)) {
            System.out.println("The expression is balanced");
        }
        else {
            System.out.println("The expression is not balanced");
        }
    }
}