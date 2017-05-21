import java.util.*;
public class AllSubSetsII {
//we could use a Hashset to store the result, and de-duplicate.
	public List<String> subSets(String set) {
    List<String> result = new ArrayList<String>();
    // corner case
    if (set == null) {
      return result;
    } else if (set.length() == 0) {
      result.add("");
      return result;
    }
    Set<String> visited = new HashSet<String>();
    char[] array = set.toCharArray();
    Arrays.sort(array);
    StringBuilder sb = new StringBuilder();
    subSetsHelper(array, 0, sb, result, visited);
    return result;
  }
  
  //dfs helper function.
  private void subSetsHelper(char[] array, int index, StringBuilder sb, List<String> result, Set<String> visited) {
    // base case
    if (index == array.length) {
      if (visited.add(sb.toString())) {
       result.add(sb.toString());
     }
      return;
    }
    if (visited.add(sb.toString())) {
      result.add(sb.toString());
    }
    for (int i = index; i < array.length; i++) {
      sb.append(array[i]);
      subSetsHelper(array, i + 1, sb, result, visited);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
 public static void main(String[] args) {
	 AllSubSetsII test =  new AllSubSetsII();
	 String s;
	 // test case
	 s = "abb";
	 System.out.println(test.subSets(s));
	 
	 s = "";
	 System.out.println(test.subSets(s));
	 
	 s = "abab";
	 System.out.println(test.subSets(s));
 }
}
