import java.util.*;
public class AddEmptySpace {
	public List<String> allPermutation(String input) {
		//assume no sanity check needed. 
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(input, sb, 0, result);
    return result;
}
 // use dfs recursion style.
	private void helper(String input, StringBuilder sb, int index, List<String> result) {
    // base case, go to the one position before last one, cause the last char has to be add to the end.
		if (index == input.length() - 1) {
			sb.append(input.charAt(index));
			result.add(sb.toString());
			//remove to recover to state of last layer.
			sb.deleteCharAt(sb.length() - 1);
			return;
		}
		
		//recursive rule.
		// add empty space or not, char has to added.
		sb.append(input.charAt(index));
		sb.append(' ');
		helper(input, sb, index + 1, result);
		sb.deleteCharAt(sb.length() - 1);
		
		helper(input, sb, index + 1, result);
		sb.deleteCharAt(sb.length() - 1);
	}
	

	public static void main(String[] args) {
		AddEmptySpace test = new AddEmptySpace();
		System.out.println(test.allPermutation("abc"));
	}
}
