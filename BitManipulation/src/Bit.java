public class Bit {
	public boolean isPowerOfTwo(int number) {
    // bit manipulation's way:
    // power of two means this integer's bit representation form only contain one '1'
    // 0010 
    //& 0001
    //  0000 
      if (number < 1) {
        return false;
    }
      return (number & (number - 1)) == 0;
    }
	
	public int diffBits(int a, int b) {
	   int result = a ^ b;
	   int i = 0;
	   int counter = 0;
	   while (i < 32) {
	     if ((result >> i & 1) == 1) {
	       counter++;
	     }
	     i++;
	   }
	   return counter;
	  }
	
	 // could use a 8 int number bit vector  
  public boolean allUnique(String word) {
    int[] dic = new int[8];
    if (word.length() == 0) {
      return true;
    }
    for (int i = 0; i < word.length(); i++) {
      // pos mean the position in charset.
      int pos = word.charAt(i);
      int row = pos / 32;
      int column = pos % 32;
      if (((dic[row] >> column) & 1) == 1) {
        return false;
      } else {
        dic[row] |= (1 << column);
      }
    }   
  return true;
  }
  
  public String hex(int number) {
    if (number == 0) {
      return new String("0x0");
    }
    char[] dic = new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
      sb.append(dic[number % 16]);
      number /= 16;
    }
    sb.append("x0");
    sb.reverse();
    return sb.toString();
  }
	  public static void main(String[] args) {
	  	Bit test = new Bit();
	  	System.out.println(test.isPowerOfTwo(3));
	  	
	  	int a = 256;
	  	int b = 5;
	  	System.out.println(test.diffBits(a, b));
	  	System.out.println(test.allUnique("abc"));
	  	System.out.println(test.hex(a));
	  }
}
