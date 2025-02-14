/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088" 
*/
import java.lang.Math;
import java.math.BigInteger;
public class Multiply_Strings {
  
  public String multiply(String num1, String num2) {

    BigInteger a = new BigInteger(num1);
    BigInteger b = new BigInteger(num2);
    
    BigInteger ans = a.multiply(b);
    
    return ans.toString();
  }

  public static void main(String[] args) {
    Multiply_Strings m1 = new Multiply_Strings();
    String num1 = "4988286601967777777777777777777777777777", num2 = "10000000000000000";
    System.out.println(m1.multiply(num1, num2));
  }
}
