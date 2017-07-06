import java.util.*;
public class SizeKAllSubSetsII {
//use dfs all subset (combination) method.
	public List<String> subSets(String set, int k) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		// temp skip sanity check.
	   char[] array = set.toCharArray();
	   Arrays.sort(array);
	   helper(array, 0, k, result, sb);
	   return result;
	}
	
	private void helper(char[] array, int index, int k, List<String> result, StringBuilder sb) {
		// base case
		if (sb.length() == k) {
			result.add(sb.toString());
			return;
		}
		if (index < array.length) {
			sb.append(array[index]);
			helper(array, index + 1, k, result, sb);
			sb.deleteCharAt(sb.length() - 1);
			// skip all duplicate char
			while (index + 1 <= array.length - 1 && array[index] == array[index + 1]) {
				index++;
			}
			helper(array, index + 1, k, result, sb);
		}
	}
	public static void main(String[] args) {
		SizeKAllSubSetsII test = new SizeKAllSubSetsII();
		System.out.println(test.subSets("abbbc", 3));
	}
}
