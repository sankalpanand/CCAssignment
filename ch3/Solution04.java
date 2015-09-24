package Chapter3;
import java.util.Stack;

public class Solution04 {

	
	
	public static void main(String[] args) throws Exception 
	{
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.pop();
		queue.pop();
		queue.pop();
		
	}

}


class MyQueue
{
	// The key to this question is to remember that at any point of time, 
	// all the elements will be present in either 1 OR 2, but not in both.
	Stack<Integer> first = new Stack<Integer>();
	Stack<Integer> second = new Stack<Integer>();

	// Before pushing, we need to check whether we already pushed some elements on to second stack.
	public void push(int x) 
	{
		// Yes, there are some elements on stack 2.
		if(second.size() > 0)
		{
			// Shift them onto stack 1, to preserve the queue order for the single queue as a whole
			while(second.size() > 0)
			{
				first.push(second.pop());
			}
		}
		
		// At this point, it is made sure that all the elements are on the first stack only.
		// It is safe to push to first.
		first.push(x);
		
		System.out.println("Push(" + x + ")");
	}

	// Removes the element from in front of queue.
	public void pop() 
	{
		// Before popping, it all the elements should be transferred to the second stack
		// We generalize that method and write it inside Peek because Peek will also use the same operation.
		peek();
		
		if(second.size() == 0)
		{
			System.out.println("No more elements to pop!");
			return;
		}
		
		// All the elements transferred to second stack. Now, pop the topmost element from stack 2. 
		int popped = second.pop();
		
		System.out.println("Pop() gives " + popped);
	}

	// Get the front element.
	public int peek() 
	{		
		if(second.isEmpty())
		{
			while(first.size() > 0)
			{
				second.push(first.pop());
			}
		}
		
		return second.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return first.isEmpty() && second.isEmpty();
	}
}
