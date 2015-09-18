package easy;

import java.util.Stack;


public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = GenerateEvenLL();
		PalindromeLinkedList obj = new PalindromeLinkedList();

		System.out.println(obj.isPalindrome(head));


	}
	
	public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null) 
            return true;
    
        ListNode slow = head;
        ListNode fast = head;
        
        // This while loop will continue till 3rd last node and
        // fast.next != null  => ODD cases
        // fast.next.next != null => Even cases
        while(fast.next != null && fast.next.next != null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        // After coming out of this while loop, situation will be like
        // Even case:
        // 0 -- 0 -- 0 -- 0 (slow) -- 0 -- 0 -- 0 (fast) -- 0 -- null
        // slow.next will give us the starting node of the second half
        // Odd case:
        // 0 -- 0 -- 0 -- 0 (slow) -- 0 -- 0 -- 0 (fast) -- null
        // Slow.next will still give us the starting node of the second half
        
        slow.next = ReverseLinkedList(slow.next);
        
        // Move into the second half
        slow = slow.next;
        
        // Start comparing
        while(slow != null)
        {
        	if(head.val != slow.val)
        		return false;
        	head = head.next;
        	slow = slow.next;
        }
        
        return true;          
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
	
	
	

}
