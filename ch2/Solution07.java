package Chapter2;

public class Solution07 {

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
		
		
		ListNode node11 = new ListNode(77);
		ListNode node12 = new ListNode(66);
		ListNode node13 = new ListNode(55);
		ListNode node14 = new ListNode(44);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node5;
		

		Solution07 obj = new Solution07();
		obj.Print(node1);
		System.out.println();
		obj.Print(node11);
		System.out.println();
		System.out.println(obj.getIntersectionNode(node1, node11).val);

	}

	/*
	 * We take count the number of nodes in each Linked Lists. 
	 * We take the difference of two list.
	 * We proceed in the longer list till the 'difference'
	 * Now since both the lists have equal number of nodes remaining.
	 * We start moving together.
	 * As we reach the same node, we return its reference.  
	 * */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
	{
		if(headA == null || headB == null) 
			return null;

		ListNode tempA = headA;
		ListNode tempB = headB;

		// Count length of first linked list
		int lenA = 0;        
		while(tempA != null)
		{
			lenA++;
			tempA = tempA.next;
		}

		// Count length of second linked list
		int lenB = 0;
		while(tempB != null)
		{
			lenB++;
			tempB = tempB.next;
		}

		// Calculate the difference
		int lenDiff = Math.abs(lenA - lenB);

		// Reset the pointers
		tempA = headA;
		tempB = headB;

		// If A is the longer list, traverse it till the difference in length
		if(lenA > lenB)
		{
			for(int i = 0; i< lenDiff; i++)
			{
				tempA = tempA.next;
			}
		}
		
		// If B is the longer list, traverse it till the difference in length
		else if(lenB > lenA)
		{
			for(int i = 0; i< lenDiff; i++)
			{
				tempB = tempB.next;
			}
		}

		// Now that both the lists have same number of elements untraversed.
		// Proceed together. Break the loop when you get the same node.
		while(tempA != tempB)
		{
			tempA = tempA.next;
			tempB = tempB.next;
		}

		return tempA;
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
