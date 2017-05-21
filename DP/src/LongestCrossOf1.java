import java.util.Arrays;

public class LongestCrossOf1 {
	public int largest(int[][] matrix) {
    //corner case
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] resultLR = leftToRight(matrix);
    int[][] resultRL = rightToLeft(matrix);
    int[][] resultTB = topToBottom(matrix);
    int[][] resultBT = bottomToTop(matrix);
    System.out.println(Arrays.deepToString(resultLR));
    System.out.println(Arrays.deepToString(resultRL));
    System.out.println(Arrays.deepToString(resultTB));
    System.out.println(Arrays.deepToString(resultBT));
    return maxOfMinMatrix(resultLR, resultRL, resultTB, resultBT);
  }
  
  // helper functions
  private int maxOfMinMatrix(int[][] matrix1, int[][] matrix2, int[][] matrix3, int[][] matrix4) {
    int m = matrix1.length;
    int n = matrix1[0].length;
    int max = 0;
    // all four matrix has the same size.
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = Math.min(Math.min(matrix1[i][j], matrix2[i][j]), Math.min(matrix3[i][j], matrix4[i][j])); 
        max = Math.max(max, result[i][j]);
      }
    }
    return max;
  }
//find the longest consecutive 1s in a array.
 private int[] longest1sLR(int[] array) {
   int[] M = new int[array.length];
   M[0] = array[0];
   for (int i = 1; i < array.length; i++) {
     if (array[i] == 0) {
       M[i] = 0;
     } else {
       M[i] = M[i - 1] + 1;
     }
   }
   return M;
 }
  private int[][] leftToRight(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      result[i] = longest1sLR(matrix[i]);
    }
    return result;
  }
  
  private int[] longest1sRL(int[] array) {
    int[] M = new int[array.length];
    M[array.length - 1] = array[array.length - 1];
    for (int i = array.length - 2; i >= 0; i--) {
      if (array[i] == 0) {
        M[i] = 0;
      } else {
        M[i] = M[i + 1] + 1;
      }
    }
    return M;
  }
  private int[][] rightToLeft(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      result[i] = longest1sRL(matrix[i]);
    }
    return result;
  }
  
  private int[][] topToBottom(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] result = new int[m][n];
    //basecase
    for (int i = 0; i < n; i++) {
      result[0][i] = matrix[0][i];
    } 
    // induction rule
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[j][i] == 0) {
          result[j][i] = 0;
        } else {
          result[j][i] = result[j - 1][i] + 1;
        }
      }
    }
    return result;
  }
  private int[][] bottomToTop(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] result = new int[m][n];
    //basecase
    for (int i = 0; i < n; i++) {
      result[m - 1][i] = matrix[m - 1][i];
    } 
    //induction rule.
    for (int i = 0; i < n; i++) {
      for (int j = m - 2; j > 0; j--) {
        if (matrix[j][i] == 0) {
          result[j][i] = 0;
        } else {
          result[j][i] = result[j + 1][i] + 1; 
        }
      }
    }
    return result;
  }
  
  
   
  
   public static void main(String[] args) {
  	 LongestCrossOf1 test = new LongestCrossOf1();
  	 int[][] matrix;
  	 // testcase
  	 matrix = new int[][]{ {0, 0, 0, 0},

  		  {1, 1, 1, 1},

  		  {0, 1, 1, 1},

  		  {1, 0, 1, 1} };
  	
  	 System.out.println(test.largest(matrix));
   }
}
