import java.util.*;
public class AllSubset {
	public List<String> subSets(String set) {
    List<String> result = new ArrayList<String>();
    // corner case
    if (set == null) {
      return result;
    }
    char[] charArray = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    subSetsHelper(charArray, sb, 0, result);
    return result;
  }
  // dfs recursive
  private void subSetsHelper(char[] charArray, StringBuilder sb, int index, List<String> result) {
    // base case
    if (index == charArray.length + 1) {
      return;
    }
    result.add(sb.toString());
    for (int i = index; i < charArray.length; i++) {
      sb.append(charArray[i]);
      subSetsHelper(charArray, sb, i + 1, result); // i is the symbol for layer.
      sb.deleteCharAt(sb.length() - 1);
    }
  }
  public static void main(String[] args) {
  	AllSubset test = new AllSubset();
    String s;
    // testcases
    s = "abc";
    System.out.println(test.subSets(s));
  	
  }
}
