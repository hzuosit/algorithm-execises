import java.util.*;
// this i pairs of () , m pairs of [], n pairs of {}.
//变成all valid subset问题考虑
public class AllValidParenthesesII {
	 private static final char[] PS =  new char[] {'(',')','[',']','{','}'};
	 public List<String> validParentheses(int l, int m, int n) {
	    int[] remain = new int[] {l,l,m,m,n,n};
	    int len = 2 * (m + n + l);
	    List<String> result = new ArrayList<String>();
	    LinkedList<Character> stack = new LinkedList<Character>();
	    StringBuilder sb = new StringBuilder();
	    helper(remain, len, result, stack, sb);
	    return result;
	  }
	 
	 private void helper(int[] remain, int len, List<String> result, LinkedList<Character> stack,StringBuilder sb) {
		 //basecase
		 if (sb.length() == len) {
			 result.add(sb.toString());
			 return;
		 }
		 
		 for (int i = 0; i < remain.length; i++) {
			 if (i % 2 == 0) {   // make sure is ( [ or {
				 if (remain[i] > 0) {
					 sb.append(PS[i]);
					 stack.push(PS[i]);
					 remain[i]--;
					 helper(remain, len, result, stack, sb);
					 sb.deleteCharAt(sb.length() - 1);
					 stack.pop();
					 remain[i]++;
				 }
			 } else {
				 if (!stack.isEmpty() && stack.peek() == PS[i - 1]) {
					 sb.append(PS[i]);
					 stack.pop();
					 remain[i]--;
					 helper(remain, len, result, stack, sb);
					 remain[i]++;
					 stack.push(PS[i - 1]);
					 sb.deleteCharAt(sb.length() - 1);
				 }
			 }
		 }
	 }
	  public static void main(String[] args) {
	  	AllValidParenthesesII test = new AllValidParenthesesII();
	  	System.out.println(test.validParentheses(1,2,0));
	  }
}
