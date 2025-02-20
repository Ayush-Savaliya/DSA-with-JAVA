/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent {
  public static int[] topKFrequent(int[] nums, int k) {
    int[] ans = new int[k];
    Map<Integer, Integer> m1 = new HashMap<>();
    for (int i = 0; i < nums.length; i++)
      if (m1.containsKey(nums[i]))
        m1.put(nums[i], m1.get(nums[i]) + 1);
      else
        m1.put(nums[i], 1);

    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(m1.entrySet());
    entryList.sort(Map.Entry.comparingByValue());

    for (int i = 0; i < k; i++) {
      ans[i] = entryList.get(m1.size()-1-i).getKey();
      System.out.println(ans[i]);
    }
    System.out.println(entryList);

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 5, 5, 7, 7 };
    int k = 3;  
    int[] ans = (topKFrequent(nums, k));
    for (int i : ans) {
      System.out.println(i);
    }
  }
}
