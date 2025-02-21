/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3

*/

import java.util.Arrays;
import java.util.HashSet;

public class Longest_Consecutive_Sequence {
 
  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0)
      return 0;

    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int max = 0;

    for (int num : set) {
      if (!set.contains(num - 1)) {
        int currentNum = num;
        int current = 1;

        while (set.contains(currentNum + 1)) {
          currentNum++;
          current++;
        }

        max = Math.max(max, current);
      }
    }

    return max;
  }
    
  public static void main(String[] args) {
    int[] nums = { 1,1,1,2,2,2,3,3,3 };
    // int[] nums = { 100,4,200,1,3,2 };
    // int[] nums = { };
    System.out.println(longestConsecutive(nums));
  }
}
