/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space. 
*/
public class Single_num {
  public int singleNumber(int[] nums) {
    int num = 0;
    for(int i=0; i<nums.length; i++){
        num ^= nums[i]; 
    }
    return num;
  }
  
  public static void main(String[] args) {
    Single_num s1 = new Single_num();

    int[] a = { 1, 2, 2 ,5,5,1,6};
    System.out.println(s1.singleNumber(a));

  }
}
