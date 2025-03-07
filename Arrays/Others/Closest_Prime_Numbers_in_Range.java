/*
Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

Example 1:
Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.

Example 2:
Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
*/

import java.util.Arrays;

public class Closest_Prime_Numbers_in_Range {

  public static boolean[] generatePrimes(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);   

    isPrime[0] = isPrime[1] = false;  

    for (int i = 2; i * i <= n; i++) {  
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) { 
                isPrime[j] = false;
            }
        }
    }
    return isPrime;
  }

  public static int[] closestPrimes(int left, int right) {
    int[] result = new int[2];
    int[] primes = new int[right - left + 1];
    boolean[] isPrime = generatePrimes(right);
    int index = 0;
    for (int i = left; i <= right; i++) {
      if (isPrime[i]) {
        primes[index++] = i;
      }
    }
    if (index < 2) {
      return new int[] { -1, -1 };
    }
    int min = Integer.MAX_VALUE;
    for (int i = index - 1; i > 0; i--) {
      if (primes[i] - primes[i - 1] <= min) {
        min = primes[i] - primes[i - 1];
        result[0] = primes[i - 1];
        result[1] = primes[i];
      }
    }
   
    return result;
  }
  public static void main(String[] args) {
    int left = 84084;
    int right = 407043;
    int[] result = closestPrimes(left, right);
    for(int i=0; i<result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }
}
