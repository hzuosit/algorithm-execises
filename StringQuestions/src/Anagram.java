import java.util.*;
public class Anagram {
	List<Integer> allAnagrams(String s, String l) {
    List<Integer> result = new ArrayList<Integer>();
    if (l.length() == 0) {
      return result;
    }
    if (s.length() > l.length()) {
      return result;
    }
    // hash the short string.
    Map<Character, Integer> small = createHash(s, s.length());
    // go check each substring
    int typeOfMatch = 0;
    // store first several character in large hashmap. and sliding a fix size windonw towards end.
    for (int i = 0; i < l.length(); i++) {
      char temp = l.charAt(i);
      Integer count = small.get(temp);
      if (count != null) {
        small.put(temp, count - 1);
        if (count == 1) {
          typeOfMatch++;
        }
      }
      if (i >= s.length()) {
        temp = l.charAt(i - s.length());
        count = small.get(temp);
        if (count != null) {
          small.put(temp, count + 1);
          if (count == 0) {
            typeOfMatch--;
          }
        }
      }
      if (small.size() == typeOfMatch) {
        result.add(i - s.length() + 1);
      }
    }
    return result;
  }  
  private Map<Character, Integer> createHash(String s, int size){
    Map<Character, Integer> small = new HashMap<Character, Integer>();
    int i = 0;
    while (i < size) {
      if (small.containsKey(s.charAt(i))) {
        small.put(s.charAt(i), small.get(s.charAt(i)) + 1);
      } else{
        small.put(s.charAt(i), 1);
      }
      i++;
    }
    return small;
  }
  
  
  public static void main(String[] args) {
  	Anagram test = new Anagram();
  	String l = "abcbac";
  	String s = "ab";
  	List<Integer> result = test.allAnagrams(s, l);
  	//System.out.println(Arrays.toString(test.createHash(l, l.length()).entrySet().toArray()));
  	System.out.println(Arrays.toString(result.toArray()));
  	
  }
}
