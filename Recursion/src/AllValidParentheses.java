import java.util.*;

public class AllValidParentheses {
	
	 public List<String> validParentheses(int n) {
	    List<String> result = new ArrayList<String>();
	    // assume n >= 0 
	    if (n == 0) {
	      result.add("");
	      return result;
	    }
	    char[] array = new char[2 * n];
	    validParenthesesHelper(array, 0,0,0,n,result);
	    return result;
	  }
	  
	  // helper function.  dfs
	  private void validParenthesesHelper(char[] array, int index, int l, int r, int n, List<String> result) {
	    //base case
	    if (l == n && r == n) {
	      result.add(new String(array, 0, array.length));
	      return;
	    }
	    // two cases, 1) when l < n we could add left parentheses.  2) when r < l we could add
	    // right parentheses.
	    //case 1.
	    if (l < n) {
	      array[index] = '(';
	      validParenthesesHelper(array, index + 1, l + 1, r, n, result);
	      array[index] = ' ';
	    }
	    // case2
	    if (r < l) {
	      array[index] = ')';
	      validParenthesesHelper(array, index + 1, l, r + 1, n, result);
	      array[index] = ' '; 
	    }
	  }
  public static void main(String[] args) {
  	AllValidParentheses test = new AllValidParentheses();
  	// test cases
  	//test.validParentheses(3);
  	System.out.println(test.validParentheses(3));
  	
  	//test.validParentheses(3);
  	System.out.println(test.validParentheses(0));
  	
  	//test.validParentheses(3);
  	System.out.println(test.validParentheses(1));
  }
}
