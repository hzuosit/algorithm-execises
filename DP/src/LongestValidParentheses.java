
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
	   // corner case
	   if (s == null || s.length() == 0) {
	     return 0;
	   }
	   char[] array = s.toCharArray();
	   int[] M = new int[array.length];
	   int counter = 0;
	   // base case
	   if (array[0] == '(') {
	     counter = 1;
	   }
	   int max = 0;
	   //induction rule.   (  )  (  (  )   counter 1
	   //                  0  2  0
	   for (int i = 1; i < array.length; i++) {
	  	 int temp = counter;
	     if (array[i] == '(') {
	    	 if (array[i - 1] == ')') {
	    		 counter++;
	    		 M[i] = M[i - 1];
	    		 continue;
	    	 } else {
	    		 counter++;
	    	 }
	     } else {
	       counter--;
	     }
	     
	     if (counter >= 0 && temp > counter) {
	    	 M[i] = M[i - 1] + 2;
	     } else if (temp < counter) {
	    	 M[i] = M[i -1];
	     } else {
	    	 M[i] = 0;
	     }
	     max = Math.max(max, M[i]);
	   }
	   if (counter > 0 && max > 0) {
	  	 max = max - counter * 2;
	   }
	   return max;
	  }
	
	public static void main(String[] args) {
		LongestValidParentheses test = new LongestValidParentheses();
		String s;
		//test
		s = "()(())";
		System.out.println(test.longestValidParentheses(s));
		s = "(";
		System.out.println(test.longestValidParentheses(s));
		s = ")(()";
		System.out.println(test.longestValidParentheses(s));
		s = "(()))";
		System.out.println(test.longestValidParentheses(s));
		s = ")()())";
		System.out.println(test.longestValidParentheses(s));
		s = "()(()";
		System.out.println(test.longestValidParentheses(s));
	}
}
