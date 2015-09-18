package Chapter2;

public class Solution02 {

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
		
		Solution02 obj = new Solution02();
		obj.Print(node1);
		System.out.println();
		System.out.println(obj.FindFromLast(node1, 8));
	}
	
	// We are sending a recursive call till the end. 
	// When the last element is reached, it will send a count to the calling function.
	// This way I will get the n'th element from the last.	
	int kthElement = 0;
	public int FindFromLast(ListNode head, int reqdCount)
	{
		helper(head, reqdCount);
		return kthElement;
	}
	
	public int helper(ListNode head, int reqdCount)
	{
		if(head == null)
			return 0;
		
		int count = 1 + helper(head.next, reqdCount);
		if(count == reqdCount)
			kthElement = head.val;
		
		return count;
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
