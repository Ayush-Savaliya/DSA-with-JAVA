public class LongestNiceSubarray {
  public static int longestNiceSubarray(int[] nums) {
    int ans = 0;
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      
      if ((nums[i] & nums[i + 1]) == 0) {
        max++;
        System.out.println(max);
      }
      else {
        if (ans < max) {
          ans = max;
        }
        max = 0;
      }
    }
    return (ans<max)? max:ans;
  }
  public static void main(String[] args) {
    // int[] a = { 1, 3, 8, 48, 10 };
    int[] a = { 3,1,5,11,13 };
    System.out.println(longestNiceSubarray(a));
  }
}
