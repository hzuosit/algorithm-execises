public class Fibonacci {
	   // assume k is no smaller than 0.
		  public long fibonacci(int k){
		    long i = 0;
		    long j = 1;
		    if(k == 0){
		      return 0;
		    }else if(k == 1){
		      return j;
		    }
		    // shift to the result we need. 
		    while(k > 1){
		      long buffer = i + j;
		      i = j;
		      j = buffer;
		      k--;
		    }
		    return j;
		  }
		  
		  public static void main(String[] args){
			  Fibonacci test = new Fibonacci();
			  // if k = 200 the value will overflow.
			  System.out.print(test.fibonacci(100));
		  }
}

