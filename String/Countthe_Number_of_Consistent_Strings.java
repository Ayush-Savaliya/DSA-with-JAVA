/*
You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

Example 1:
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent. 
*/
public class Countthe_Number_of_Consistent_Strings {
  public int countConsistentStrings(String allowed, String[] words) {
    boolean[] s = new boolean[26];
    for (char c : allowed.toCharArray()) {
      s[c - 'a'] = true;
    }
    int ans = 0;
    for (String w : words) {
      if (check(w, s)) {
        ++ans;
      }
    }
    return ans;
  }

    private boolean check(String w, boolean[] s) {
      for (int i = 0; i < w.length(); ++i) {
        if (!s[w.charAt(i) - 'a']) {
          return false;
        }
      }
      return true;
    }
    

  public static void main(String[] args) {
    String allowed = "abc";
    String[] words = { "a","b","c","ab","ac","bc","abcd" };
    // String allowed = "cad";
    // String[] words = { "cc", "acd", "b", "ba", "bac", "bad", "ac", "d" };
    Countthe_Number_of_Consistent_Strings c1 = new Countthe_Number_of_Consistent_Strings();
    System.out.println(c1.countConsistentStrings(allowed, words));
  }
}
