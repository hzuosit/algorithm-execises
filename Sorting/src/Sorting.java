import java.util.*;

//this project includes implementation of all important sorting algorithm. including selection sort, merge sort
public class Sorting {
	// insertion sort in ascending order
	public static  int[] InsertionSort(int [] a){
		int temp;
		if (a == null || a.length == 0){
			return a;
		}
		for (int i = 0 ; i < a.length-1; i++){
			for(int j = i+1; j>=1;j--){
				if(a[j]<a[j-1]){
					temp = a[j-1];
					a[j-1] =  a[j];
					a[j] = temp;	
				} else {
					break;
				}
			}
		}
		return a;
	}
	// selection sort in ascending order
	public static int[ ] selectionSort(int[]array){
		int temp,index_global;
		int n = array.length;
		if (n==0 || array == null){
			return array;
		}
		for (int i=0; i<n-1;i++){
			index_global = i;
			for (int j=i+1;j<n;j++){
				if (array[j]<array[index_global]){
					index_global = j;
				}
			}
			temp = array[i];
			array[i] = array[index_global];
			array[index_global] = temp;
		}
		return array;
	}
	
	
	
	
	
	// merge sort in ascending order
	//function that calls merge sort
	// left: the left index of the sub array
	// right: the right index of the sub array
	public static int[] mergeSortFunction(int[] array) {
	    int left = 0;
	    int right = array.length-1;
	    if (array.length == 0 || array == null){
			return array;
		}else{
	       array = mergeSort(array,left,right);
	       return array;
		}
	  }
	public static int[] mergeSort(int []array,int left,int right){
		int [] result = new int[array.length];
		//base case
		if (left == right){
			int[] temp = new int [1];
            temp[0]=array[left];
            return temp;
		}
		// recursively call merge sort function.
		int mid = left + (right - left) /2;
		int [] left_sub = mergeSort(array, left,  mid);
		int [] right_sub = mergeSort(array,  mid+1,  right);
		result = mergeSortCombine(left_sub,right_sub);
		return result;
	}
	// merge Sort Combination,  only applicable when two sub array are all sorted.
	public static int[] mergeSortCombine(int[] left_sub, int[] right_sub){
		int [] result = new int[left_sub.length+right_sub.length];
		int result_pointer  = 0;
		int left_pointer = 0;
		int right_pointer = 0;
		while(left_pointer<left_sub.length && right_pointer < right_sub.length ){
			if (left_sub[left_pointer] <= right_sub[right_pointer]){
				result[result_pointer] = left_sub[left_pointer];
				result_pointer ++;
				left_pointer++;
			}else{
				result[result_pointer] = right_sub[right_pointer];
				result_pointer ++;
				right_pointer++;
			}
		}
		while (left_pointer<left_sub.length){
			result[result_pointer] = left_sub[left_pointer];
			result_pointer ++;
			left_pointer++;
		}
		while(right_pointer < right_sub.length ){
			result[result_pointer] = right_sub[right_pointer];
			result_pointer ++;
			right_pointer++;
		}
		return result;
	}
	
	
	
	
	
	
	// quick sort implementation.
	// left: the left index of the array
	// right: the right index of the array
	public static int[] quickSort(int[]array){
		// all corner case
		if( array == null || array.length == 0 ){
			return array;
		}
		//quicksortFunction.
		int left = 0;
		int right = array.length-1;
		quickSortFunction(array,left,right);
		return array;		
	}
	
	public static int[] quickSortFunction(int[]array,int left,int right){
		//base case: array has zero or one element.
		//"left>=right". when a zero sub-array need to be quicksorted, left>right happens. 
		// 2  (1)
		if(left>=right){
			return array;
		}
		int pivot = medianOfThree(array,left,right);
		swap(array,pivot,right);
		int i  = left;
		int j = right-1;
		//partitioning
		while(i<=j){
			if (array[i] >array[right]){
				swap(array,i,j);
				j--;
			}else{
				i++;
			}
		}
		swap(array,i,right);
		//recursively doing partition for smaller sub array and greater sub array
		quickSortFunction(array,left,i-1);
	    quickSortFunction(array,i+1,right);
		
		return array;
	}
	//median of three for quicksort
	
	public static int medianOfThree(int[]array, int left,int right){
		int mid = left + (right-left) / 2;
		if (array[left]>array[right]){
			swap(array,left,right);
		}else if (array[mid]>array[right]){
			swap(array,mid,right);
		}else if (array[left]>array[mid]){
			swap(array,left,mid);
		}
		return mid;
	}
	// swap function
	public static void swap(int[]array, int left, int right){
		int temp  = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	//print function
	public static void printA(int[]a){
		for (int i = 0;i<a.length;i++){
			System.out.print(a[i]+ " ");
		}
	}
	
	//main funtion
	public static void main(String [ ] args){
		int [] a  = {3,1,5};
		int [] b = {6,4,7,1};
		int [] array = {4,4,3,3,2,2,1};
		//Sorting.selectionSort(a);
		System.out.print("\n");
	    System.out.println(Arrays.toString(array));
	    //test mergeSortCombine
	    //int [] c = Sorting.mergeSortCombine(a, b);
	    //Sorting.mergeSortFunction(array);
	    //System.out.println(Arrays.toString(c));
	    //System.out.println(Arrays.toString(d));
	    //Sorting.selectionSort(array);
	    Sorting.quickSort(array);
	    System.out.println(Arrays.toString(array));
	    
	    //note that the the result of msgInvalidDue will overflow if using int.
	    //long c = 60 * 24 * 3600 * 1000L;
	    //int d = (1<<31)-1;
	    //System.out.println(d);
	}
}
