import java.util.Arrays;

public class Kclosest {
	public int[] kClosest(int[] array, int target, int k) {
		  // corner case check.
		  if (array == null || array.length == 0) {
		    return array;
		  }
		  int pointer = closest(array, target);
		  int[] result = new int[k];
		  int leftP = pointer;
		  int rightP = pointer + 1;
		  int i = 0;
		  // post processing, expand from the result index to k closest element.
		  // by distance between target and new positions. 
		  while (leftP >= 0 && rightP < array.length && i < k ) {
		    if (array[rightP] - target >= target - array[leftP]) {
		      result[i] = array[leftP];
		 	leftP--;
		      i++;
		    } else {
		      result[i] = array[rightP];
		      rightP++;
			i++;
		    }
		  }
		  while (leftP >= 0 && i < k) {
		    result[i] = array[leftP];
		    leftP--;
		    i++;
		  }
		  while (rightP < array.length && i < k) {
		    result[i] = array[rightP];
		      rightP++;
			i++;
		  }
		  return result;
		}

		public int closest(int[] array, int target)  {
		  int left = 0;
		  int right = array.length - 1;
		  while (left < right -1) {
		    int mid = left + (right - left)/2;
		    if (array[mid] == target) {
		      return mid;
		    } else if (array[mid] < target) {
		  	left = mid;
		    } else {
		    	right = mid;
		    }
		  }
		  // find out which is closer.
		  if (target - array[left] <= array[right] - target)  {
		    return left;
		  } else {
		    return right;
		  }
		}

		public static void main(String[] args){
			Kclosest test = new Kclosest();
			//test cases
			int[ ] array = new int[ ] {1,2,5,6,7,8,9};
			System.out.print(Arrays.toString(test.kClosest(array, 5, 4)));
		} 
}
