/*
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.

Example 2:
Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.

 */
public class FindNumberswithEvenNumberofDigits {
  public static int findNumbers(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int flag = 0;
      while (nums[i] > 0) {
        nums[i] /= 10;
        flag++;
      }
      if (flag % 2 == 0) {
        count++;
      }
    }
    return count;
  }
  public static void main(String[] args) {
    int[] a = { 12, 345, 2, 6, 7896 };
    System.out.println(findNumbers(a)); // Output: 2
    int[] b = { 12, 2, 4345, 2, 66, 57896 };
    System.out.println(findNumbers(b)); // Output: 3
  }
}
