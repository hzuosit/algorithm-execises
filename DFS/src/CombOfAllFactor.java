import java.util.*;
// print all valid combination of factor of an integer. assume all positive.
// need to know what are all the factor first, then do a DFS to it.
// time complexity: O(n!) k-nary tree, space O(2n)->O(n)
public class CombOfAllFactor {
  public List<List<Integer>> allComb(int n) {
  	List<List<Integer>> result = new ArrayList<List<Integer>>();
  	List<Integer> cur = new ArrayList<Integer>();
  	//santiy check
  	if (n <= 3) {
  		return result;
  	}
  	int[] array = toArray(allFactor(n));
  	dfsHelper(array, n, result, cur, 0);
  	return result;
  }
  
  // dfs, size array layers, each layer has how many element and what left.
  private void dfsHelper(int[] array, int r, List<List<Integer>> result, List<Integer> cur, int index) {
  	// base case
  	if (index == array.length - 1) {
  		// if valid add to collection.
  		// remain == how many array[index]
  			int i = valid(r, array[index]);
  			if (i >= 0) {
  				cur.add(i);
  				result.add(new ArrayList<Integer>(cur));
  				cur.remove(cur.size() -  1);
  		}	
  	  return;
  	}
  	//recursive rules.
  	for (int i = 0; i <= t(r, array[index]); i++) {
  			cur.add(i);
    		if (i == 0) {
    			dfsHelper(array, r, result, cur, index + 1);
    		} else {
    			if (r % (int)Math.pow(array[index], i) == 0) {
    				dfsHelper(array, r / (int)(Math.pow(array[index], i)), result, cur, index + 1);
    			}
    		}	
    		cur.remove(cur.size() - 1);
  	}
  }
  // how many element * element in r.
  private int t(int r, int element) {
  	int temp = 1;
  	int counter = 0;
  	while (temp <= r) {
  		temp *= element;
  		counter++;
  	}
  	return counter - 1;
  }
  // valid helper function,  return how many element left of r.
  private int valid(int r, int element) {
  	if (r == 1) {
  		return 0;
  	}
    for (int i = 0; i < r; i++) {
    	if ((int)Math.pow(element, i) == r) {
    		return i;
    	}
    }
    return -1;
  }
  private int[] toArray(List<Integer> input) {
  	int[] result = new int[input.size()];
  	for (int i = 0; i < input.size(); i++) {
  		result[i] = input.get(i);
  	}
  	return result;
  }
  // helper function find all factor, need to take care corner case.
  private List<Integer> allFactor(int n) {
  	List<Integer> result = new ArrayList<Integer>();
  	//corner cases
  	if (n <= 1) {
  		return result;
  	}
  	for (int i = 2; i < n; i++) {
  		if (n % i == 0) {
  			result.add(i);
  		}
  	}
  	return result;
  }
  
  public static void main(String[] args) {
  	CombOfAllFactor test = new CombOfAllFactor();
  	System.out.println(test.allFactor(4));
  	System.out.println(test.allComb(4));
  	System.out.println(test.t(3,3));
  }
}
