package Chapter2;

public class Solution01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		Solution01 obj = new Solution01();
		obj.Print(node1);
		System.out.println();
		obj.removeDuplicates(node1);
		obj.Print(node1);
	}
	
	
	// The idea is to start with head.
	// Send a second pointer through the entire list.
	// Whenever a match is found, delink it from the linked list chain
	// Then, do the same thing with 2nd, 3rd node and so on.
	// Complexity - O(n^2)
	public void removeDuplicates(ListNode head)
	{
		ListNode slowPointer = head;
		
		while(slowPointer != null)
		{
			ListNode fastPointer = slowPointer;
			
			while(fastPointer.next != null)
			{
				// Duplicate found, skip it 
				if(fastPointer.next.val == slowPointer.val)
					fastPointer.next = fastPointer.next.next;
				
				// Everything fine, go ahead !
				else
					fastPointer = fastPointer.next;
			}
			
			// Repeat the same procedure with the next node
			slowPointer = slowPointer.next;
		}
	}
	
	public void Print(ListNode head)
	{
		while(head != null)
		{
			System.out.print(head.val + " -> ");
			head = head.next;
		}
			
	}

}
