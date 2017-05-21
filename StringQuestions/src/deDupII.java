import java.util.*;
public class deDupII {
	public String deDup(String input) {
	    //corner case
	    if (input == null || input.length() == 0) {
	      return input;
	    }
	    char[] array = input.toCharArray();
	    int fast = 1;
	    int slow = 0;
	    //            f
	    //    a b b b a a c c z
	    //    s
	    // marker = false
	    while (fast < array.length) {
	      if (slow < 0 || array[fast] != array[slow]) {
	        array[++slow] = array[fast];
	        
	      } else if (array[fast] == array[slow]) {
	        // skip all the consecutive duplicate char and pop stack.
	        slow--;
	        while (fast < array.length - 1 && array[fast] == array[fast + 1]) {
	          fast++;
	        } 
	      }
	      fast++; 
	    }
	    return new String(array, 0, slow + 1);
	 }
	
	public static void main(String[] args){
		deDupII test = new deDupII();
		// test cases
		String s = new String("aab");
		System.out.println(test.deDup(s));
	}
}
