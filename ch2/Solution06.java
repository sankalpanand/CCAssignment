package Chapter2;

public class Solution06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		Solution06 obj = new Solution06();
		obj.Print(node1);
		System.out.println();
		System.out.println(obj.isPalindrome(node1));
		
	}

	/*
	 * We reach till the end using recursion and keep a class level pointer to head.
	 * When last node is reached, we start comparing the elements.
	 * As the recursive stack empties out, we increment the head pointer.
	 * */
	ListNode temp;
    public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null) 
            return true;
    
        temp = head;
        return helper(head);  
    }
    
    public boolean helper(ListNode node)
    {
        if(node.next == null)
        {
            if(node.val == temp.val)
                {
                    temp = temp.next;
                    return true;
                }
            else
            {
                return false;
            }
        }
        
        boolean result = helper(node.next);
        
        if(result == true && (node.val == temp.val))
        {
            temp = temp.next;
            return true;
        }
        
        return false;
            
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
