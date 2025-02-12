public class RemoveParentheses {
  public static void main(String[] args) {
    String input = "))(a)(";
    String result = minRemoveToMakeValid(input);
    System.out.println(result);
  }

  public static String minRemoveToMakeValid(String s) {
    StringBuilder sb = new StringBuilder();
    int open = 0;

    // First pass: remove invalid closing parentheses
    for (char c : s.toCharArray()) {
      if (c == '(') {
        open++;
      } else if (c == ')') {
        if (open == 0) continue;
        open--;
      }
      sb.append(c);
    }
    // Second pass: remove invalid opening parentheses
    StringBuilder result = new StringBuilder();
    int balance = 0;
    for (int i = sb.length() - 1; i >= 0; i--) {
      char c = sb.charAt(i);
      if (c == '(') {
        if (balance == 0) continue;
        balance--;
      } else if (c == ')') {
        balance++;
      }
      result.append(c);
    }

    return result.reverse().toString();
  }
}