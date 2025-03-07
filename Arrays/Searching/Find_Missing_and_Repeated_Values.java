/*
You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

Example 1:
Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].

Example 2:
Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
 
*/

public class Find_Missing_and_Repeated_Values {
  public int[] findMissingAndRepeatedValues(int[][] grid) {
    int n = grid.length;
    int[] result = new int[2];
    int[] arr = new int[n * n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[grid[i][j]]++;
      }
    }
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == 0) {
        result[1] = i;
      } else if (arr[i] == 2) {
        result[0] = i;
      }
    }

    return result;
  }
  
  public static void main(String[] args) {
    // int[][] grid = { {1,3}, {2,2} };
    int[][] grid = { {9,1,7}, {8,9,2}, {3,4,6} };
    Find_Missing_and_Repeated_Values obj = new Find_Missing_and_Repeated_Values();
    int[] result = obj.findMissingAndRepeatedValues(grid);
    for (int i : result) {
      System.out.print(i + " ");
    }
  }
}
