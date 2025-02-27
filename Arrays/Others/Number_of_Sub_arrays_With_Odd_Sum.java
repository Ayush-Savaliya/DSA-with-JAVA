/*
Given an array of integers arr, return the number of subarrays with an odd sum.
Since the answer can be very large, return it modulo 109 + 7.

Example 1:
Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

Example 2:
Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

Example 3:
Input: arr = [1,2,3,4,5,6,7]
Output: 16
 
*/
public class Number_of_Sub_arrays_With_Odd_Sum {
   public int numOfSubarrays(int[] arr) {
        int evenCount = 1;  
        int oddCount = 0;  
        int prefixSum = 0;
        int result = 0;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                result += oddCount;  
                evenCount++;
            } else {
                result += evenCount;  
                oddCount++;  
            }
        }
        return result;
    }  public static void main(String[] args) {
    Number_of_Sub_arrays_With_Odd_Sum solution = new Number_of_Sub_arrays_With_Odd_Sum();
    int[] arr1 = {1,3,5};
    int[] arr2 = {2, 4, 6};
    int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
    System.out.println(solution.numOfSubarrays(arr1)); // Output: 4
    System.out.println(solution.numOfSubarrays(arr2)); // Output: 0
    System.out.println(solution.numOfSubarrays(arr3)); // Output: 16
  }
}


