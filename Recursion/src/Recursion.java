public class Recursion {
	public ListNode reverse(ListNode head) {
	    // corner case head == null
		if(head == null){
			return null;
		}
		if(head.next == null){
			return head;
		}
	    return head;
	 }
	
	public static void main(String [] args){
		ListNode node = new ListNode();
		
	}
}
