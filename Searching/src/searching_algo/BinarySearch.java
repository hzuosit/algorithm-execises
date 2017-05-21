package searching_algo;

import java.util.Arrays;

public class BinarySearch {
	//classical version
	public int binarySearch(int[] array, int target){
		// corner case if array is size zero or one or null
		if(array == null || array.length == 0){
			return  -1;
		}
		int left = 0;
		int right = array.length-1;
		//      1                   1       2	
		//   LMR               LM    R
		while(left<=right){
			int mid = left + (right-left) / 2;
			if(array[mid] == target){
				return mid;
			}else if (array[mid]<target){
				left = mid+1;
			} else{
				right = mid-1;
			}
		}
		return -1;
	}
	
	
	//using binary search to search a m by n matrix. return position.
	// 1   2   3   4
	// 5   6   7   8 
	// 9 10 11 12
	// treat this matrix as 1-d, r = index/length of m[0]   c = index % length of m[0]
	public int[ ] binarySearch_matrix(int [ ][ ] matrix, int target){
		if (matrix.length  == 0 || matrix[0].length== 0){
			return new int [] {-1,-1};
		}
		int left = 0;
		int right = matrix.length * matrix[0].length -1;
		while(left<=right){
			int mid  = left + (right-left)/2;
			int r = mid / matrix[0].length;
			int c = mid % matrix[0].length;
			if (matrix[r][c] == target){
				return new int [] {r,c};
			} else if (matrix[r][c]< target){
				left = mid + 1;
			}else {
				right = mid-1;
			}
		}
		return  new int [] {-1,-1};
	}
	
	public long power(int a, int b) {
	    //corner cases
	    if(a == 0){
	      return 0;
	    }
	    if(b == 0){
	      return 1;
	    }
	    long half_result = power(a, b/2);
	    if (b%2 ==0){
	      return half_result * half_result;
	    }else{
	      return half_result * half_result*a;
	    }
	  }
	
	//dp solution with o(1) space
	public long fibonacci(int K) {
		long i = 0;
		long j = 1;
		if(K<=0){
			return i;
		}
		if(K==1){
			return j;
		}
		while(K>1){
			long buff  = i+j;
			i = j;
			j = buff;
			K--;
		}
		return j;
	}
		
	// binary search first occurence.
	public int firstOccur(int[] array, int target) {
		//corner case when array is null or zero
		if(array == null || array.length  == 0 ){
			return -1;
		}
		int left = 0;
		int right = array.length-1;
		// stop when L and R are neighbor.
		while(left<right-1){
			int mid = left + (right-left)/2;
			if(array[mid] == target){
				right = mid;
			}else if(array[mid]<target){
				left = mid;
			}else{
				right = mid;
			}
		}
		if(array[left] == target){
			return left;
		}else if(array[right]==target){
			return right;
		}
		
		return -1;
	  }

	//binary search last occurance. 
	public int lastOccur(int[] array, int target) {
		//corner case when array is null or zero
		if(array == null || array.length  == 0 ){
			return -1;
		}
		int left = 0;
		int right = array.length-1;
		// stop when L and R are neighbor.
		while(left<right-1){
			int mid = left + (right-left)/2;
			if(array[mid] <= target){
				left = mid;
			}else{
				right = mid;
			}
		}
		if(array[left] == target){
			return left;
		}else if(array[right]==target){
			return right;
		}
		return -1;
	  }

	// find the index of closest to the target
	public int closest(int[] array, int target) {
	    if(array == null || array.length == 0){
	    	return -1;
	    }
	    int left = 0;
	    int right = array.length-1;
	    while(left<right-1){
	    	int mid = left + (right-left)/2;
	    	if(array[mid]==target){
	    		return mid;
	    	}else if(array[mid]>target){
	    		right = mid;
	    	}else{
	    		left = mid;
	    	}
	     } 
	    
	    if(Math.abs(array[right] - target) < Math.abs(array[left] - target) ){
	    	return right;
	    }else{
	    	return left;
	    }
	  }
	
	//find the k closest element.
	public int[] kClosest(int[] array, int target, int k) {
		if(array == null || array.length == 0){
	    	return array;
	    }
	 if ( k == 0){
		 return new int [0];
	 }
	 int left = 0;
	 int right = array.length-1;
	 int index;
	 // find the closest point.
	 index = Closest(array,left,right,target);
	 
	 // post processing, find k elements.
	 int [] result = new int[k];
	 int i = 0; 
	 int left1 = index;
	 int right1 = index+1;
	 while(left1>0 && right1<array.length && i<k){ 		 
	   if (Math.abs(array[right1] - target) <= Math.abs(array[left1] - target)){	
	       result[i] = array[right1];
           right1++;
		   i++;
		 }else{
		   result[i]=array[left1];
		   left1--;
		   i++;
		 }
	  }
	    
	    while(left1>=0 && i<k){
	    	result[i] = array[left1];
	    	left1--;
	    	i++;
	    }
	    while(right1<=array.length && i<k){
	    	result[i]=  array[right1];
	    	right1++;
	    	i++;
	    }
	   
	    return result;
}

private int Closest(int[] array, int left, int right, int target){
	  while(left<right-1){
		    	int mid = left + (right-left)/2;
		    	if(array[mid] == target){
		    		return mid;
		    	}else if(array[mid]>target){
		    		right = mid;
		    	}else{
		    		left = mid;
		    	}
		}
		
		if(Math.abs(array[right] - target) < Math.abs(array[left] - target) ){
		  return right;
		}else{
		  return left;
		}
	}

        // 	}else if (Math.abs(array[right] - target) < Math.abs(array[left] - target) ){
	   // result[0]  = array[left]; 
      // else if (Math.abs(array[right] - target) > Math.abs(array[left] - target)){
	 //result[0] = array[right];
		 
	
	
	public static void main(String[] args){
		int [] a = {1,3,3,6,9,9,12,15};
		int []  b = {1};
		int [][] m = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
		BinarySearch  r = new BinarySearch();
		//int result = r.binarySearch(a,4);
		//int[] c = r.kClosest(a, 0,3);
		//System.out.print(Arrays.toString(c));
		//System.out.println(Arrays.toString(r.binarySearch_matrix(m, 7)));
		long d = r.fibonacci(1);
		System.out.println(d);
	}
}

