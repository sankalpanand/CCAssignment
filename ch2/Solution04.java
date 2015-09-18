package Chapter2;

public class Solution04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(8);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(10);
		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		Solution04 obj = new Solution04();
		obj.Print(node1);
		System.out.println();
		ListNode newHead = obj.partition(node1, 5);
		obj.Print(newHead);
	}

	/*
	 * We create two ListNode pointers. We traverse the given list.
	 * We start creating smaller list and the greater list as we go
	 * When we are done with the main list, we link the smaller's end to the greater's start.
	 * */

	public ListNode partition(ListNode head, int x) 
	{
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode p1 = dummy1;
		ListNode p2 = dummy2;
		
		while(head != null)
		{
			if(head.val < x)
			{
				p1.next = head;
				p1 = p1.next;
			}
			else
			{
				p2.next = head;
				p2 = p2.next;
			}
			
			head = head.next;
		}
		
		// Link smaller list with the start of greater list
		p1.next = dummy2.next;
		
		// Terminate the greater list
		p2.next = null;
		
		// Return the head of smaller list
		return dummy1.next;
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
