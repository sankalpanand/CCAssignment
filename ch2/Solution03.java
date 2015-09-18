package Chapter2;

public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		Solution03 obj = new Solution03();
		obj.Print(node1);
		System.out.println();
		obj.deleteNode(node4);
		obj.Print(node1);
	}

	/*
	 * We start from the given node towards the end.
	 * We keep on copying the next value onto the current
	 * As soon as we reach the 2rd node from the last, we break out of the loop.
	 * When we come out of the loop,we copy the last element onto this one.
	 * Also we mark its next as NULL.  
	 * */
	public void deleteNode(ListNode node) 
	{
		while(node.next.next != null)
		{
			node.val = node.next.val;
			node = node.next;
		}

		node.val = node.next.val;
		node.next = null;
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
