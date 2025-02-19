/*
Given two strings s and t, return true if t is an 
anagram of s, and false otherwise.

Example 1:
Input: s = "aba", t = "aab"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
*/

import java.util.Map;
import java.util.HashMap;

public class Valid_Anagram {

  public boolean isAnagram(String s, String t) {
        
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> m1 = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (m1.containsKey(s.charAt(i))) {
        m1.put(s.charAt(i), m1.get(s.charAt(i)) + 1);
      } else {
        m1.put(s.charAt(i), 1);
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (m1.containsKey(t.charAt(i))) {
        if (m1.get(t.charAt(i)) <= 0) {
          return false;
        } else {
          m1.put(t.charAt(i), m1.get(t.charAt(i)) - 1);
        }
      }
      else{
        return false;
      }
    }

    return true;
  }
  public static void main(String[] args) {
    // String s = "gfedcba", t = "abcdefg";
    // String s = "aba", t = "aab";
    String s = "rat", t = "car";

    Valid_Anagram v1 = new Valid_Anagram();
    System.out.println(v1.isAnagram(s, t));
  }
}