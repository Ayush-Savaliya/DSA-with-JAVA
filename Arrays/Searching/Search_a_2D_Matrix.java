/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/

import java.util.Arrays;

public class Search_a_2D_Matrix {

  public static boolean searchMatrix(int[][] matrix, int target) {
    
    int middle = matrix.length / 2;
    int left = 0;
    int right = matrix[middle].length - 1;
    if (matrix.length == 0)
      return false;

    if (target < matrix[middle][0]) {
      if (middle == 0) return false;
      return searchMatrix(Arrays.copyOfRange(matrix, 0, middle), target);
    } else if (target > matrix[middle][right]) {
      if (middle + 1 == matrix.length) return false;
      return searchMatrix(Arrays.copyOfRange(matrix, middle + 1, matrix.length), target);
    } else {
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (matrix[middle][mid] == target)
          return true;
        if (matrix[middle][mid] < target)
          left = mid + 1;
        else
          right = mid - 1;
      } 
    }
    return false;
  }
  public static void main(String[] args) {
    int[][] matrix = { {1} };
    int target = 2;
    System.out.print(searchMatrix(matrix, target));
  }
}