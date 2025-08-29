package Strings;

import java.util.Stack;

public class Valid_Parentheses_20{

    public static boolean isValid(String s) {
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse each character in the string
        for(char c : s.toCharArray()){
            
            // If it's an opening bracket → push it to the stack
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } 
            // Otherwise it's a closing bracket
            else {
                // If stack is empty, there is no opening bracket to match → invalid
                if(stack.isEmpty()) return false;

                // Pop the last opening bracket from stack
                char top = stack.pop();

                // Check if the popped opening bracket matches the current closing bracket
                // Example: ')' must match '('
                if((c == ')' && top != '(') ||
                   (c == ']' && top != '[') ||
                   (c == '}' && top != '{')){
                    return false; // mismatch found
                }
            }
        }
        
        // If stack is empty at the end → all brackets matched correctly
        // If not empty → some opening brackets were not closed
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("{[]}")); // true
    }

}