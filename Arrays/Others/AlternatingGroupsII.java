/*
There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:

colors[i] == 0 means that tile i is red.
colors[i] == 1 means that tile i is blue.
An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
Return the number of alternating groups.
Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.

Example 1
Input: colors = [0,1,0,1,0], k = 3
Output: 3

Example 2:
Input: colors = [0,1,0,0,1,0,1], k = 6
Output: 2

Example 3:
Input: colors = [1,1,0,1], k = 4
Output: 0
 */
public class AlternatingGroupsII {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        // Step 1: Create an array that tracks if pairs of consecutive elements alternate
        boolean[] isAlternating = new boolean[n];
        for (int i = 0; i < n; i++) {
            isAlternating[i] = colors[i] != colors[(i + 1) % n];  // Check alternating pairs
        }

        // Step 2: Use a sliding window to count alternating groups of size k
        int windowAlternatingCount = 0;
        
        // Initialize the first window
        for (int i = 0; i < k - 1; i++) {
            if (isAlternating[i]) {
                windowAlternatingCount++;
            }
        }

        // Slide the window across the array
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = (i + k - 1) % n;

            // If the window is alternating, increment the count
            if (windowAlternatingCount == k - 1) {
                count++;
            }

            // Move the window: Remove the old left element and add the new right element
            if (isAlternating[start]) {
                windowAlternatingCount--;
            }
            if (isAlternating[end]) {
                windowAlternatingCount++;
            }
        }

        return count;
    }
   public static void main(String[] args) {
    // System.out.println(numberOfAlternatingGroups(new int[]{1, 2, 1, 2, 1, 2}, 2));
    // System.out.println(numberOfAlternatingGroups(new int[]{1, 2, 1, 2, 1, 2}, 3));
    // System.out.println(numberOfAlternatingGroups(new int[]{1, 2, 1, 2, 1, 2}, 4));
     int[] colors1 = {0, 1, 0, 1, 0};
        int k1 = 3;
        System.out.println(numberOfAlternatingGroups(colors1, k1)); // Output: 3

        int[] colors2 = {0, 1, 0, 0, 1, 0, 1};
        int k2 = 6;
        System.out.println(numberOfAlternatingGroups(colors2, k2)); // Output: 2

        int[] colors3 = {1, 1, 0, 1};
        int k3 = 4;
        System.out.println(numberOfAlternatingGroups(colors3, k3)); // Output: 0
  }
}
