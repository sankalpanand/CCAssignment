package Chapter2;


public class Solution05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;

		ListNode node11 = new ListNode(5);
		ListNode node22 = new ListNode(9);
		ListNode node33 = new ListNode(2);
		node11.next = node22;
		node22.next = node33;

		Solution05 obj = new Solution05();
		obj.Print(node1);
		System.out.println();
		obj.Print(node11);
		System.out.println();
		ListNode newHead = obj.addTwoNumbers(node1, node11);
		obj.Print(newHead);

		// FOLLOW UP
		System.out.println("\nReverse");
		newHead = obj.addTwoNumbersWithHeadsGiven(node1, node11);
		obj.Print(newHead);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		if(l1 == null) return l2;
		else if(l2 == null) return l1;

		ListNode previous = new ListNode(0);
		ListNode dummy = previous;

		int carry = 0;

		while(l1 != null || l2 != null || carry != 0)
		{
			ListNode curr = new ListNode(0);

			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			curr.val = sum % 10;
			carry = sum/10;

			previous.next = curr;
			previous = curr;

			// I had a question that if I am checking l1 and l2 being null above then why do I need to check again?
			// If I dont check it here, l1.next will throw exception when l1 is already null
			l1 = l1 == null? l1 : l1.next;
			l2 = l2 == null? l2 : l2.next;			
		}
		return dummy.next;
	}


	// If we have links to the head of the numbers, 
	// We can simply reverse the numbers, perform addition and reverse the result
	public ListNode addTwoNumbersWithHeadsGiven(ListNode l1, ListNode l2) 
	{
		if(l1 == null) return l2;
		else if(l2 == null) return l1;

		ListNode l1Rev = ReverseLinkedList(l1);
		ListNode l2Rev = ReverseLinkedList(l2);

		ListNode resultReverse = addTwoNumbers(l1Rev, l2Rev);

		ListNode result = ReverseLinkedList(resultReverse);

		return result;


	}



	public ListNode ReverseLinkedList(ListNode head)
	{
		ListNode pre = null;
		ListNode next = null;

		while(head != null)
		{
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}

		return pre;
	}


	public int getSize(ListNode head)
	{
		if(head == null) return 0;
		return 1 + getSize(head.next);
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
