import java.util.ArrayList;

public class MulOfArrays {

  void fun(int[] a, int b, int x , int zero ,int ans[][]){
    int y;
    for (y = 0; y < zero; y++) {
      ans[x][y] = 0;
    }
    
    for (int p = a.length-1; p >= 0; p--) {
      ans[x][y++] = a[p]*b;
    }
  }



  public static void main(String[] args) {
    MulOfArrays m = new MulOfArrays();
    int alen, blen;
    // int[] a = {9,9,9,0,1};
    // int[] b = {9,9,9,1};
    int a[] = {1,2};
    int b[] = {1,2};
    alen = a.length;
    blen = b.length;
    int[][] ans = new int[blen][alen + blen ];
    for (int i = 0; i < blen; i++) {
      m.fun(a, b[i], i, blen - 1 - i, ans);
    }

    for (int[] row : ans) {
      for (int x : row)
        System.out.print(x + " ");
      System.out.println();
    }

    int c = 0, d = 0; 
    ArrayList<Integer> ans2 = new ArrayList<Integer>();
    
    for (int i = 0; i < alen + blen ; i++) {
      int sum = 0 + c;
      for (int j = 0; j < blen; j++) {
        sum += ans[j][i];
      }

      if (sum > 9) {
        c = sum / 10;
        sum = sum % 10;
        ans2.add(sum);
      } else {
        c = 0;
        ans2.add(sum);
      }
    }
     System.out.print(ans2.reversed());
    }
}