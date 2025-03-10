/*
You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

Example 1:
Input: word = "aeioqq", k = 1
Output: 0
Explanation:
There is no substring with every vowel.

Example 2:
Input: word = "aeiou", k = 0
Output: 1
Explanation:
The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

Example 3:
Input: word = "ieaouqqieaouqq", k = 1
Output: 3
Explanation:
The substrings with every vowel and one consonant are:
word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".

 */
public class CountSubstrings {
    public int countSubstrings(String word, int k) {

        int[][] freq = new int[2][128];
        freq[0]['a'] = 1;
        freq[0]['e'] = 1;
        freq[0]['i'] = 1;
        freq[0]['o'] = 1;
        freq[0]['u'] = 1;
        
        long response = 0;
        int current = 0, vowels = 0, extraleft = 0;
        for (int right = 0, left = 0; right < word.length(); right++) {
            if (freq[0][word.charAt(right)] == 1) {
                if (++freq[1][word.charAt(right)] == 1) {
                    vowels++;
                }
            } else {
                current++;
            }
            while (current > k) {
                if (freq[0][word.charAt(left)] == 1) {
                    if (--freq[1][word.charAt(left)] == 0) {
                        vowels--;
                    }
                } else {
                    current--;
                }
                left++;
                extraleft = 0;
            }
            while (vowels == 5 && current == k && left < right && freq[0][word.charAt(left)] == 1
                    && freq[1][word.charAt(left)] > 1) {
                extraleft++;
                freq[1][word.charAt(left)]--;
                left++;
            }
            if (vowels == 5 && current == k) {
                response += (extraleft + 1);
            }
        }
        
        return (int) response;
    }
    
    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("ieaouqqieaouqq", 1));
    }
}