import java.util.*;
public class SizeKSubSet {
  public List<List<Integer>> subSet(int[] array, int k) {
  	List<List<Integer>> result = new ArrayList<List<Integer>>();
  	List<Integer> A = new ArrayList<Integer>();
  	if (k > array.length) {
  		return result;
  	}
  	helper(array, A, k, 0, result);
  	return result;
  }
  
  // dfs helper
  private void helper(int[] array, List<Integer> A, int k, int index, List<List<Integer>> result) {
  	// base case
  	if (A.size() == k) {
  		result.add(new ArrayList<>(A));
  		return;
  	}
  	
  	//recursive rule
  	if (index <= array.length - 1) {
  		A.add(array[index]);
    	helper(array, A, k, index + 1, result);
    	A.remove(A.size() - 1);
    	helper(array, A, k, index + 1, result);
  	}		
  }
  
  public static void main(String[] args) {
  	SizeKSubSet test = new SizeKSubSet();
  	int[] array = new int[]{1,2};
  	System.out.println(test.subSet(array, 2));
  }
}
