
public class LongestXShape {
	 public int largest(int[][] matrix) {
     if (matrix.length == 0 || matrix[0].length == 0) {
       return 0;
     }
     int[][] leftTop = leftTop(matrix);
     int[][] rightBottom = rightBottom(matrix);
     return combine(leftTop, rightBottom);
  }
  
  // left top
  private int[][] leftTop(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0]. length;
    int[][] left = new int[m][n];
    int[][] top = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          left[i][j] = getElement(left, i - 1, j - 1, m, n) + 1;
          top[i][j] = getElement(top, i - 1, j + 1, m, n) + 1;
        }
      }
    }
    combine(left, top);
    return left;
  }
  // right bottom
  private int[][] rightBottom(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0]. length;
    int[][] right = new int[m][n];
    int[][] bottom = new int[m][n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          right[i][j] = getElement(right, i + 1, j + 1, m, n) + 1;
          bottom[i][j] = getElement(bottom, i + 1, j - 1, m, n) + 1;
        }
      }
    }
    combine(right, bottom);
    return right;
  }
  //function to read the element of matrix. m n is the row and column of matrix
  // all element out of range mark zero
  private int getElement(int[][] matrix, int x, int y, int m, int n) {
    if (x < 0 || y < 0 || x >= m || y >= n) {
      return 0;
    }
    return matrix[x][y];
  }
  // merge two matrix, result is the max of Mins'
  private int combine(int[][] m1, int[][] m2) {
    int m = m1.length;
    int n = m1[0]. length;
    int result = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        m1[i][j] = Math.min(m1[i][j], m2[i][j]);
        result = Math.max(result, m1[i][j]);
      }
    }
    return result;
  }
  public static void main(String[] args) {
  	LongestXShape test = new LongestXShape();
  	int[][] matrix;
  	// test cases
  	matrix = new int[][] { {0, 0, 0, 0},

  	  {1, 1, 1, 1},

  	  {0, 1, 1, 1},

  	  {1, 0, 1, 1} };
  	System.out.println(test.largest(matrix));
  	
  	matrix = new int[][] {{1,0,1,0,1},
  												{1,1,0,1,1},
  												{0,0,1,1,0},
  												{1,1,1,1,0},
  												{1,0,0,1,1}};
  	System.out.println(test.largest(matrix));
  }
}
