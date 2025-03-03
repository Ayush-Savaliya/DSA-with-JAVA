/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Three_Pointer_Sum {
  public static List<List<Integer>> threeSum(int[] nums) {

    HashSet<Integer> set = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0;i<nums.length-2;i++){
      if(i==0 || (i>0 && nums[i]!=nums[i-1])){
        int lptr = i+1;
        int rptr = nums.length-1;
        int sum = 0-nums[i];
        while(lptr<rptr){
          if(nums[lptr]+nums[rptr]==sum){
            result.add(Arrays.asList(nums[i],nums[lptr],nums[rptr]));
            while(lptr<rptr && nums[lptr]==nums[lptr+1]) lptr++;
            while(lptr<rptr && nums[rptr]==nums[rptr-1]) rptr--;
            lptr++;
            rptr--;
          }else if(nums[lptr]+nums[rptr]<sum){
            lptr++;
          }else{
            rptr--;
          }
        }
      }
    }
    return result;
  }
 public static void main(String[] args){
    // int[] nums = {-1, 0, 1, 2, -1, -4};
    int[] nums = { 0,0,0};
    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
  }
}
