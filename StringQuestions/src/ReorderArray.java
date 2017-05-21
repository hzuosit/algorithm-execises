import java.util.Arrays;
public class ReorderArray {
	 // same as abcd1234 - > a1b2c3d4 
  //  ab cd 12 34 -> ab 12 cd 34 -> a1 b2 c3 d4
	public int[] reorder(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    //call helper, even and odd length will have slightly different process.
    if (array.length % 2 == 0) {
    	reorderHelper(array, 0, array.length - 1);
    } else {
    	reorderHelper(array, 0, array.length - 2);
    }
    return array;
  }
  
  //reorderHelper
  private void reorderHelper(int[] array, int left, int right){
    // base case
    if (right - left <= 1) {
      return;
    }
    int size = right - left + 1;
    //divid the array into four chunk, and apply "i love yahoo" trick to the 
    // chunk2 and chunk3, then, do this process for leftsub array and rightsub array.
    int mid = left + size / 2;
    int leftmid = left + size / 4;
    int rightmid = left + size * 3 / 4;
    //reverse words then reverse sentence.
    reverse(array, leftmid, mid - 1);
    reverse(array, mid, rightmid - 1);
    reverse(array, leftmid, rightmid - 1);
    reorderHelper(array, left, left + 2 * (leftmid - left)- 1);
    reorderHelper(array, left + 2 * (leftmid - left), right);
  }
  // reverse function, iterative way.
  private void reverse(int[] array, int start, int end) {
    if (array.length <= 1) {
      return;
    }
    //two pointer reverse
    while (start <= end) {
      int temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      start++;
      end--;
    }
  }
  public static void main(String[] args){
  	ReorderArray test = new ReorderArray();
  	// test case       l     m   r         chunk1[0 - 2] chunk2[3 - 4]  chunk3[5 - 7] chunk4[8 - 9]     
  	int[] array = new int[]{1,2,3,4,5,6}; // 
  	test.reorder(array);
  	System.out.println(Arrays.toString(array));
  	
  	array = new int[] {1,2,3};
  	test.reorder(array);
  	System.out.println(Arrays.toString(array));
  	
  	array = new int[] {1,2,3,4,5,6,7};
  	test.reorder(array);
  	System.out.println(Arrays.toString(array));
  	
  	array = new int[] {1,2,3,4,5,6,7,8};
  	test.reorder(array);
  	System.out.println(Arrays.toString(array));
  	
  	array = new int[] {1};
  	test.reorder(array);
  	System.out.println(Arrays.toString(array));
  	
  	array = new int[] {};
  	test.reorder(array);
  	System.out.println(Arrays.toString(array));
  }
}
