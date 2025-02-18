/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true 
*/

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
  public boolean containsDuplicate(int[] nums) {

    Set<Integer> a = new HashSet<Integer>();
    for(int num:nums){
      if (a.contains(num)) {
        return true;
      } else {
        a.add(num);
      }
    }

    return false;
  }
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5 };
    Contains_Duplicate c1 = new Contains_Duplicate();
    System.out.println(c1.containsDuplicate(a));;
  }
}
