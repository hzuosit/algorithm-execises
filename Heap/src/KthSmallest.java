import java.util.*;
// kth smallest in sorted array.
class MatrixNode {
	  int column;
	  int row;
	  int value;
	  public MatrixNode(int row, int column, int value) {
	    this.row = row;
	    this.column = column;
	    this.value = value;
	  }
	  //override hashCode() and equals()
	  @Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (!(o instanceof MatrixNode)) {
	      return false;
	    }
	    MatrixNode other = (MatrixNode) o;
	    return this.column == other.column && this.row == other.row && this.value == other.value;
	  }
	  @Override 
	  public int hashCode() {
	    return this.row * 31 * 31 + this.column * 31 + this.value;
	  }
	}
public class KthSmallest {
	  // use a min heap to keep min value, use a hashset to mark visited, create a matrixNode
	  // class for easier implementation.
	  public int kthSmallest(int[][] matrix, int k) {
	    int n = matrix.length;
	    int m = matrix[0].length;
	    //create a min heap and ovveride it's Comparator.
	    Queue<MatrixNode> minHeap = new PriorityQueue<MatrixNode>(k, new Comparator<MatrixNode>() {
	      @Override
	      public int compare(MatrixNode n1, MatrixNode n2) {
	        if (n1.value == n2.value) {
	          return 0;
	        } 
	        return n1.value < n2.value ? -1 : 1;
	      }
	    });
	    // create a hashset to mark visited.
	    Set<MatrixNode> visited = new HashSet<MatrixNode>();
	    MatrixNode node = new MatrixNode(0, 0, matrix[0][0]);
	    minHeap.offer(node);
	    visited.add(node);
	    // just need to go k - 1 times.
	    for (int i = 0; i < k - 1; i++ ) {
	      MatrixNode cur = minHeap.poll();
	      // from left to right
	      if (cur.column + 1 < m) {
	        MatrixNode next = new MatrixNode(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]);
	        if (visited.add(next)) {
	          minHeap.offer(next);
	        }
	      }
	      // from top to bottom
	      if (cur.row + 1 < n) {
	        MatrixNode next = new MatrixNode(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]);
	        if (visited.add(next)) {
	          minHeap.offer(next);
	        }
	      }
	    }
	    return minHeap.peek().value;
	  }
	  
	  public static void main(String[] args) {
	  	KthSmallest test = new KthSmallest();
	  	// test cases
	  	int[][] matrix = new int [][]{ {1,  3,   5,  7}, {2,  4,   8,   9}, {3,  5, 11, 15},{6,  8, 13, 18}};
	  	System.out.println(test.kthSmallest(matrix, 8));
	  }
	}
