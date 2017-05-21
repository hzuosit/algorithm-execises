import java.util.*;
public class LongestSubstring {
//use hashmap to keep track of the element and frequency of each character in side window.
  public int longest(String input) {
    // corner case
    if (input.length() == 0) {
      return 0;
    }
    int max = 0;
    HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
    //two pointer strategy, start and end, from left to right, when start++, add new element or update
    // element frequency in dic,  when key > 1 move end pointer and decrease the frequency accrodingly.
    int end = 0;
    int start = 0;
    while (start < input.length()) {
      char cur  = input.charAt(start);
      //add a new character
      if (!dic.containsKey(cur)) {
        dic.put(cur, 1);
      } else {
        dic.put(cur, dic.get(cur) + 1);
      }
      
      if (dic.get(cur) > 1) {
        while (dic.get(cur) > 1) {
          char pre = input.charAt(end);
          dic.put(pre, dic.get(pre) - 1);
          end++;
        }
      }else {
        if (start - end + 1 > max) {
          max = start - end + 1;
        }
      }
      start++;
    }
    return max;
  }
  
  public static void main(String [] args){
  	LongestSubstring  test = new LongestSubstring();
  	String input = "bcdgedfg";
  	System.out.println(test.longest(input));
  }
}
