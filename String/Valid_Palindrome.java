/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/

public class Valid_Palindrome {

  public static boolean isPalindrome(String s) {
    String s1 = s.toLowerCase();
    String r = "";
    for (char ch :s1.toCharArray())
      if (Character.isLetterOrDigit(ch))
        r += ch;

    String t = "";
    for (char ch : r.toCharArray())
      t = ch + t;
    
      System.out.println(t);
      System.out.println(r);
      
      return t.equals(r);
  }
  public static void main(String[] args) {
    // String s = "race a car";
    // String s = "A man, a plan, a canal: Panama";
    String s = "0p";
    System.out.println(isPalindrome(s));
  }

}