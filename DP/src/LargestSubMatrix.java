import java.util.Arrays;

public class LargestSubMatrix {
	public int largest(int[][] matrix) {
    //assumption m >= 1 n >= 1
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] columnSum = columnSumMatrix(matrix, m,n);
    // go through all column pairs in sum column. create a array which very 
    // element is the sum of column from range [i][n] to [j][n], then we
    // find the largest sum in this array, the result is submatrix's  largest sum.
    int[] r = new int[m];
    int max = matrix[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = i; j < m; j++) {
        r = compress(matrix, columnSum, i, j);
        max = Math.max(maxSum(r), max);
      }
    }
    return max;
  }
  // find the subarray with max sum.
  private int maxSum(int[] array) {
    int maxEndsHere = array[0];
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      maxEndsHere = Math.max(maxEndsHere + array[i], array[i]);
      max = Math.max(max, maxEndsHere);
    }
    return max;
  }
  // create a array based on two column range. i < j
  private int[] compress(int[][] matrix, int[][] columnSum, int i, int j) {
    int[] result = new int[matrix[0].length];
    for (int k = 0; k < result.length; k++) {
      result[k] = columnSum[j][k] - columnSum[i][k] + matrix[i][k];
    }
    //System.out.println(Arrays.toString(result));
    return result;
  }
  // pre processing helper.
  private int[][] columnSumMatrix(int[][] matrix, int m, int n) {
    int[][] result = new int[m][n];
    //basecase
    for (int i = 0; i < n; i++) {
    	result[0][i] = matrix[0][i];
    }
    
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < m; j++) {
        result[j][i] = result[j - 1][i] + matrix[j][i];
      }
    }
    //System.out.println(Arrays.deepToString(result));
    return result;
  }
  public static void main(String[] args) {
  	LargestSubMatrix test = new LargestSubMatrix();
  	int[][] matrix;
  	//test cases
  	//matrix = new int[][]{{1}};
  	//System.out.println(test.largest(matrix));
  	
  	matrix = new int[][]{ {1, -2, -1, 4},

  	  										{1, -1,  1, 1},
  										{0, -1, -1, 1},
										{0,  0,  1, 1} };
  	System.out.println(test.largest(matrix));
  	
  	matrix = new int[][]{{1,2,3},{0,3,2},{3,0,1}};
    System.out.println(test.largest(matrix));
    //System.out.println(test.maxSum(new int[] {4,5,6}));
    //{{-1,-2,-3},{-4,-3,-2},{-3,0,-1}}
    matrix = new int[][]{{-1,-2,-3},{-4,-3,-2},{-3,0,-1}};
    System.out.println(test.largest(matrix));
  	
  }
}
