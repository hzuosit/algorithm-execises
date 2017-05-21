import java.util.Arrays;

public class testsome {
	
	public static void swap(int[]array, int left, int right){
		int temp  = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static int[] swapToTheEnd(int[]array,int j){
        while(j<array.length-1){
            swap(array,j,j+1);
            j++;
        }
        return array;
	}
	public static void main(String[] args) {
		int [] a  ={0,0,1,6,5};
		int[] b  = testsome.swapToTheEnd(a, 3);
		System.out.println(Arrays.toString(b));

	}

}
