package Chapter3;
import java.util.Stack;

public class Solution05 {

	public static void main(String[] args) {

		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		/* Worst Case */
		stack1.push(48);
		stack1.push(32);
		stack1.push(21);
		stack1.push(18);
		stack1.push(11);
		stack1.push(6);	
		stack1.push(4);	
		stack1.push(2);


		System.out.println(stack1);
		// Complexity is O(n)
		// Worst case is when the stack is already sorted
		// The top most element will travel 2 * number of elements

		// The idea is to take out an element from the original stack,
		// keep popping items from the helper stack as long as they are lesset than the above element.
		// This will settle the largest element down the bottom of second stack.
		// Repeat this process until there are some elements left in the original array.
		while(! stack1.isEmpty())
		{
			// Take out the temp
			int temp = stack1.pop();

			// Keep transferring elements from helper stack to the original stack 
			// as long as they are smaller than the popped element of the original stack
			// This way, you are 
			while(! stack2.isEmpty() && temp > stack2.peek() )
			{
				stack1.push(stack2.pop());
			}			

			stack2.push(temp);
		}

		// After this operation, the original stack becomes empty. Refill it.
		while (!stack2.isEmpty())
		{			
			stack1.push(stack2.pop());
		}

		System.out.println(stack1);

	}
}
