/*
You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

Each queries[i] represents the following action on nums:

Decrement the value at each index in the range [li, ri] in nums by at most vali.
The amount by which each value is decremented can be chosen independently for each index.
A Zero Array is an array with all its elements equal to 0.

Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.

Example 1:
Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
Output: 2
Explanation:
For i = 0 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [1, 0, 1].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.

Example 2:
Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
Output: -1
Explanation:
For i = 0 (l = 1, r = 3, val = 2):
Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
The array will become [4, 1, 0, 0].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
The array will become [3, 0, 0, 0], which is not a Zero Array.
*/
 
 import java.util.Arrays;

public class ZeroArrayTransformationII {
    public int minQueriesToZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int left = 0, right = queries.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canAchieveZeroArray(nums, queries, mid + 1)) {
                right = mid; // Try to find a smaller k
            } else {
                left = mid + 1; // Increase k
            }
        }

        return left == queries.length ? -1 : left + 2; // If left equals queries.length, return -1
    }

    private boolean canAchieveZeroArray(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] decrements = new int[n + 1]; // Difference array for range updates

        // Apply the first k queries
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            decrements[l] += val; // Start decrementing from l
            if (r + 1 < n) {
                decrements[r + 1] -= val; // Stop decrementing after r
            }
        }

        // Apply the difference array to get the actual decrements
        int currentDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentDecrement += decrements[i];
            if (nums[i] > currentDecrement) {
                nums[i] -= currentDecrement; // Decrement the value
            } else {
                nums[i] = 0; // It can be fully decremented to zero
            }
        }

        // Check if all elements are zero
        for (int num : nums) {
            if (num > 0) {
                return false; // If any element is still greater than zero
            }
        }

        return true; // All elements are zero
    }

    public static void main(String[] args) {
        ZeroArrayTransformationII a = new ZeroArrayTransformationII();
        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};
        System.out.println(a.minQueriesToZeroArray(nums1, queries1)); // Output: 2

        int[] nums2 = {4, 3, 2, 1};
        int[][] queries2 = {{1, 3, 2}, {0, 2, 1}};
        System.out.println( a.minQueriesToZeroArray(nums2, queries2)); // Output: -1
    }
}