import java.util.*;
public class MergeSort {
	/*
	public int[] mergeSort(int[] array){
	    // corner case
	    if(array == null || array.length <= 1){
	      return array;
	    }
	    return mergeSort(array, 0, array.length - 1); 
	  }
	  // merge sort.
	  public int[] mergeSort(int[]array, int left, int right){
	    // base case
	    if(left == right){
	    	 // cause array's size is not change... we only need array[left] 
	    	// or array[right]( in this case, same thing.) to return to the next step 
	    	// to do the combine work.
	      int[] temp = new int[1]; 
	      temp[0] = array[left];
	      return temp;
	    }
	    int mid = left + (right - left) / 2;
	    int[] leftSub = mergeSort(array, left, mid);
	    int[] rightSub = mergeSort(array, mid + 1, right);
	    return mergeCombine(leftSub, rightSub);
	  }
	  //combination left sub and right sub.
	  public int[] mergeCombine(int[] leftSub, int[] rightSub){
	    int[] result = new int[leftSub.length + rightSub.length];
	    int leftP = 0;
	    int rightP = 0;
	    int resultP = 0;
	    while(leftP <= leftSub.length - 1 && rightP <= rightSub.length -1 ){
	      if(leftSub[leftP] <= rightSub[rightP]){
	        result[resultP++] = leftSub[leftP++];
	      }else{
	          result[resultP++] = rightSub[rightP++];
	        }
	      }
	      while(leftP <= leftSub.length - 1){
	        result[resultP++] = leftSub[leftP++];
	      }
	      while(rightP <= rightSub.length - 1){
	        result[resultP++] = rightSub[rightP++];    
	      }
	      return result;  
	    }
	  */
	// a better Space is  o(n) solution.
	// mergesort with O(n) space complexity.
	  public int[] mergeSort(int[] array) {
	    // corner case
	    if (array == null || array.length == 0) {
	      return array;
	    }
	    //mergeSort
	    int[] helper = new int[array.length];
	    mergeSort(array, 0, array.length - 1, helper);
	    return array;
	  }
	  
	  private void mergeSort(int[] array, int left, int right, int[] helper) {
	    // base case
	    if (left == right) {
	      return;
	    }
	    int mid = left + (right - left) / 2;
	    mergeSort(array, left, mid, helper);
	    mergeSort(array, mid + 1, right, helper);
	    merge(array, left, right, mid, helper);
	  }
	  
	  private void merge(int[] array, int left, int right, int mid, int[] helper) {
	    int leftPointer = left;
	    int rightPointer = mid + 1;
	    // use helper to merge.
	    for (int i = left; i <= right; i++) {
	      helper[i] = array[i];
	    }
	    while (leftPointer <= mid && rightPointer <= right) {
	      if (helper[leftPointer] < helper[rightPointer]) {
	        array[left++] = helper[leftPointer++];
	      } else {
	        array[left++] = helper[rightPointer++];
	      }
	    }
	    while (leftPointer <= mid) {
	      array[left++] = helper[leftPointer++];
	    }
	    //at his time element on the right already in there position.
	  }
	  public static void main(String[] args){
		  MergeSort test = new MergeSort();
		  
		  // testcases
		  int[] array = new int[]{3,2,1};
		  System.out.println(Arrays.toString(test.mergeSort(array)));
		  
		  array = new int[]{};
		  System.out.println(Arrays.toString(test.mergeSort(array)));
		  
		  array = new int[]{2,1};
		  System.out.println(Arrays.toString(test.mergeSort(array)));
		  
		  array = null;
		  System.out.println(Arrays.toString(test.mergeSort(array)));
		  
		  array = new int[]{1,1,4,4,3,3,2,2,10};
		  System.out.println(Arrays.toString(test.mergeSort(array)));
	  }
}
