import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubSetsII {
	// use dfs all subset (combination) method.
	public List<String> subSets(String set) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		// temp skip sanity check.
	   char[] array = set.toCharArray();
	   Arrays.sort(array);
	   helper(array, 0, result, sb);
	   return result;
	}
	
	private void helper(char[] array, int index, List<String> result, StringBuilder sb) {
		// base case
		if (index == array.length) {
			result.add(sb.toString());
			return;
		}
		sb.append(array[index]);
		helper(array, index + 1, result, sb);
		sb.deleteCharAt(sb.length() - 1);
		// skip all duplicate char
		while (index + 1 <= array.length - 1 && array[index] == array[index + 1]) {
			index++;
		}
		helper(array, index + 1, result, sb);
	}
	
	public static void main(String[] args) {
		AllSubSetsII test = new AllSubSetsII();
		System.out.println(test.subSets("abab"));
	}
}
	
