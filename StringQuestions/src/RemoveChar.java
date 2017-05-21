import java.util.*;
public class RemoveChar {
	public String remove(String input, String t) {
	    if (input.length() == 0) {
	      return new String();
	    }
	    if (t.length() == 0) {
	      return input;
	    }
	    // create char array based on input string 
	    char[] in = input.toCharArray();
	    // create a hash set based on character needs to be deleted.
	    Map<Character, Integer> delete = new HashMap<Character, Integer>();
	    for (int i = 0; i < t.length(); i++) {
	      char cur = t.charAt(i);
	      if (delete.containsKey(cur)) {
	        delete.put(cur, delete.get(cur) + 1);
	      }else {
	        delete.put(cur, 1);
	      }
	    }
	    // two pointer strategy.
	    int slow = 0;
	    int fast = 0;
	    while (fast < in.length ) {
	      if (delete.containsKey(in[fast])) {
	        fast++;
	      }else {
	        in[slow++] = in[fast++];
	      }
	    }
	    //result is [0,slow)
	    return new String(Arrays.copyOfRange(in, 0, slow));
	  }
	
	public static void main( String[] args) {
		RemoveChar test = new RemoveChar();
		//test case
		String input = "";
		String t = "avc";
		System.out.println(test.remove(input, t));
	}
}
