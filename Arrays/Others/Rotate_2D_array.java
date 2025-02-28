public class Rotate_2D_array{
  public static void rotate(int[][] matrix) {
    int[][] a = new int[matrix.length][matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        a[j][matrix.length - 1 - i] = matrix[i][j];
      }
    }
     for (int[] is : a) {
       for (int is2 : is) {
         System.out.print(is2 + " ");
       }
      System.err.println();
    }
  }
  public static void main(String[] args) {
    int[][] a = { { 1, 2, 3}, { 4, 5, 6}, { 7, 8, 9} };
    rotate(a);
    // for (int[] is : a) {
    //   for (int is2 : is) {
    //     System.out.print(is2 + " ");
    //   }
    //   System.err.println();
    // }
  }
}
