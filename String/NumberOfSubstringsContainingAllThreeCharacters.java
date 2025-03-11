/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1
 
*/

import java.util.HashMap;

public class NumberOfSubstringsContainingAllThreeCharacters {
  public static int numberOfSubstrings(String s) {
    int n = s.length();
    int count = 0;
    int left = 0;

    HashMap<Character, Integer> freq = new HashMap<>();

    for (int right = 0; right < n; right++) {
      freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

      while (freq.size() == 3) {
        count += (n - right);

        char leftChar = s.charAt(left);
        freq.put(leftChar, freq.get(leftChar) - 1);
        if (freq.get(leftChar) == 0) {
          freq.remove(leftChar);
        }
        left++;
      }
    }

    return count;
  }
  public static void main(String[] args) {
    System.out.println(numberOfSubstrings("abcabc")); // 10
    System.out.println(numberOfSubstrings("aaacb")); // 3
    System.out.println(numberOfSubstrings("abc")); // 1
  }
}
