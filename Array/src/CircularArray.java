// Implement a circular array as a bonded queue. FIFO
// the tail pointer point to the position we offer(write), 
//the head pointer point to the position we poll(read).
// We have two ways to determine whether the circular array is empty or full
//   1). when size == array.length array is full.  
//   2) when head + 1 == tail is full and head == tail is empty 
//API includes peek() offer() peek() isEmpty() write() read()
public class CircularArray {
	private int head;
	private int tail;
	private int[] array;
	int size;
	private final static int DEFAULT_CAP = 15;
	
	public CircularArray() {
		this(DEFAULT_CAP);
	}
  public CircularArray(int cap) {
  	if (cap <= 0) {
  		throw new IllegalArgumentException("Capacity cannot smaller than 1!");
  	}
		array = new int[cap];
		head = 0;
		tail = 0;
		size = 0;
	}
  //offer (as Queue)
  public boolean offer(Integer input) {
  	if(size == array.length) {
  		return false;
  	}
  	array[tail] = input;
  	tail = (tail + 1) % array.length;
  	size++;
  	return true;
  }
  //write (as CircularArray)
  public boolean write(Integer input) {
  	if(size == array.length) {
  		return false;
  	}
  	array[tail] = input;
  	tail = (tail + 1) % array.length;
  	size++;
  	return true;
  }
  //poll(as Queue)
  public Integer poll() {
  	if (size == 0) {
  		return null;
  	}
  	int result = array[head];
  	head = (head + 1) % array.length;
  	size--;
  	return result;
  }
  //read(as Circular array)
  public Integer read() {
  	if (size == 0) {
  		return null;
  	}
  	int result = array[head];
  	head = (head + 1) % array.length;
  	size--;
  	return result;
  }
  //peek
  public Integer peek() {
  	if (size == 0) {
  		return null;
  	}
  	return array[head];
  }
  //isEmpty
  public boolean isEmpty() {
  	return size == 0;
  }
  // isFUll
  public boolean isFull() {
  	return size == array.length;
  }
  
  public static void main(String[] args) {
  	CircularArray test = new CircularArray();
  	int[] array = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
  	for (int i : array) {
  		test.write(i);
  	}
  	System.out.println("circular array is empty? " + test.isEmpty());
  	System.out.println("circular array is full? " + test.isFull());
  	System.out.println("The element on the top is  " + test.peek());
  	System.out.println("read " + test.read());
  	System.out.println("read " + test.poll());
  	System.out.println(test.offer(16));
  	System.out.println(test.offer(17));
  	System.out.println(test.offer(18));
  	System.out.println(test.peek());
  }
}
