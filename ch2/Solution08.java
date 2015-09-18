package Chapter2;

public class Solution08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node5;
		

		Solution08 obj = new Solution08();		
		System.out.println(obj.detectCycle(node1).val);

	}

	/*
	 * It's a mathematical concept.
	 * First go to that point where cycle is detected.
	 * Then start one pointer from head and another from the point of cycle detected.
	 * Move both one step at a time.
	 * Point where both the pointers meet is the start of the loop.
	 * */
	public ListNode detectCycle(ListNode head)
	{
		// If head is null or a single node, then there can't be any loop
		if(head == null || head.next == null) 
			return null;
		
		ListNode firstPointer = head;
		ListNode secondPointer = head;
		boolean cycleDetected = false;
		
		// As soon as any pointer reaches the end, break the loop
		while(firstPointer != null && secondPointer != null)
		{
			// Move first pointer single step and second pointer 2 steps
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next == null ? null : secondPointer.next.next;
			
			// Check for loop
			if(firstPointer == secondPointer)
			{
				cycleDetected = true;
				break;
			}
		}
		
		// If the loop was not detected but any linked list reached its end, return false
		if(cycleDetected == false) 
			return null;
		
		// Reset first pointer
		firstPointer = head;
		
		// Now move both the pointers at the same pace until they meet
		while(firstPointer != secondPointer)
		{
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}
		
		return firstPointer;
		
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
