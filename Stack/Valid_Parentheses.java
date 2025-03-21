package Stack;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
*/

import java.util.Stack;

public class Valid_Parentheses {

  public static boolean isValid(String s) {
    if (s.length() % 2 != 0)
      return false;
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (!stack.isEmpty()) {
          char top = stack.peek();
          if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
            stack.pop();
          } else {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
}

  public static void main(String[] args) {
    // String input = "(){}[]";
    String input = "))";
    boolean result = isValid(input);
    System.out.println(result);
  }
}
