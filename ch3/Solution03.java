package Chapter3;

import java.util.ArrayList;
public class Solution03 {



	public static void main(String[] args) throws Exception 
	{
		SetOfStacks set = new SetOfStacks(3);
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		set.push(6);
		set.push(7);
		set.push(8);
		set.push(9);
		set.push(10);
		set.popAt(2);
		set.popAt(2);
		set.DisplayStacks();
	}



}

class SetOfStacks
{		
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;


	public SetOfStacks(int capacity) 
	{
		this.capacity = capacity;
	}	

	public void push(int v)
	{
		// Get the last stack. If there is no stack, it will return null.
		Stack lastStack = getLastStack();

		// Check if the last stack is not full, then push on it 
		if(lastStack != null && !lastStack.isFull())
		{
			lastStack.push(v);
		}
		// If it is full OR there is not even a single stack present, create new.
		else
		{
			// create a new stack
			Stack stack = new Stack(capacity);

			// Push value on it
			stack.push(v);

			// Add this newly created stack to the [stacks]
			stacks.add(stack);
		}

		// Print the status
		System.out.println("Number of stacks -> " + stacks.size());
	}

	public int pop()
	{
		// Get last stack
		Stack lastStack = getLastStack();

		if(lastStack == null)
		{
			System.out.println("Exception. Stack size already zero. No element to pop.");
			return -1;
		}

		// Pop an element out of this stack
		int poppedElement = lastStack.pop();

		// Check if it's size == 0, delete it from stacks
		if(lastStack.size == 0)
			stacks.remove(stacks.size() - 1);

		// Print the status
		System.out.println("Number of stacks -> " + stacks.size());

		// return the element		
		return poppedElement;
	}

	/**
	 * @return The last stack in the ArrayList of stacks. If there are no stacks, it returns null.
	 */
	public Stack getLastStack() 
	{
		int size = stacks.size();

		// It means there is not even a single stack present
		if(size == 0) 
			return null;

		return stacks.get(size - 1);
	}

	public boolean isEmpty()
	{
		Stack last = getLastStack();
		return (last == null) || last.isEmpty();
	}

	public int popAt(int index)
	{
		int popped = leftShift(index, true); 
		// Print the status
		System.out.println("Number of stacks -> " + stacks.size());
		return popped;
	}


	/** This method removes the element from the stack at the given index.
	 * This method does two things - 
	 1. It removes the top element from the requested stack by passing bool = true the first time
	 2. It removes the bottom element from the following stacks recursively by passing bool = false, 
	 and pushing that removed element to the current stack.
	 So, it starts calling leftShift() to all the stacks to its left until the last stack is reached
	 It removes an element from the right one and pushes it to the left one.
	 * @param index
	 * @param removeTop
	 * @return
	 */
	public int leftShift(int index, boolean removeTop)
	{
		// Get the stack at the given index
		Stack stack = stacks.get(index);

		// If remove top is true, get the item at top 
		int removed_item;
		if (removeTop) 
			removed_item = stack.pop();

		// Remove_Top is false, so get the item from the bottom
		else 
			removed_item = stack.removeBottom();


		// If stack had just one element, after removing the top it will become empty.
		// Remove that stack from the StackList
		if (stack.isEmpty()) 
		{
			stacks.remove(index);
		}

		// The requested stack falls in the middle and is not the last stack.
		// So, we need to steal one element from the next stack and adjust it in the current one.
		else if (stacks.size() > index + 1) 
		{
			// Steal an item from the next stack
			int v = leftShift(index + 1, false);

			// Store that item to the current stack
			stack.push(v);
		}

		// If the recursive call is over, return the removed item. 
		// It will be used to add on the calling stack.
		return removed_item;
	}

	public void DisplayStacks()
	{
		for(Stack stack : stacks)
		{			
			stack.DisplayStack();
			System.out.println();
		}

	}
}

class Stack 
{
	private int capacity;
	public int size = 0;

	public Node top;
	public Node bottom;


	public Stack(int capacity) 
	{ 
		this.capacity = capacity; 
	}

	public boolean isFull() 
	{ 
		return (capacity == size); 
	}

	public void join(Node above, Node below) 
	{
		if (below != null) below.above = above;
		if (above != null) above.below = below;
	}

	public boolean push(int v) 
	{
		// Check if the size overruns the capacity
		if (size >= capacity) 
			return false; // Return failure

		// Increase the size by 1
		size++;

		// Create a new node which will hold the pushed data
		Node n = new Node(v);

		// If the size becomes 1 after increasing, it means this is the first element in the stack. 
		if (size == 1) 
			bottom = n; // make the bottom pointer poinnt to this node

		// 1 = above, 2 = below
		// We are piling up the new node on top of the existing top node
		join(n, top);

		// Make the top pointer point to the newly 
		top = n;

		// Return success
		return true;
	}

	public int pop() 
	{
		// Extract the top node
		Node t = top;

		// Move the pointer to point at the node below it
		top = top.below;

		// Decrease the size by 1
		size--;

		// Return the value of the popped node
		return t.value;
	}

	public boolean isEmpty() 
	{ 
		return (size == 0); 
	}

	/** This method simply removes the bottom node, after the operation, 
	 * there will be one less items in the stack.
	 * @return Removed item
	 */
	public int removeBottom() 
	{
		// Get the node which lies at the bottom of the stack
		Node b = bottom;

		// Move the bottom pointer upwards by 1, because we are removing the bottom
		bottom = bottom.above;

		// If newly shifted bottom is not null (means the removed element was not the single element), 
		// make its below point to null, because it is now bottom 
		if (bottom != null) 
			bottom.below = null;

		// decrease the size
		size--;

		// return the value of previously extracted bottom node
		return b.value;
	}

	public void DisplayStack() 
	{
		Node temp = top;
		while(temp != null)
		{
			System.out.print(temp.value + " <- ");			
			temp = temp.below;
		}
	}
}

class Node 
{
	public Node above;
	public Node below;
	public int value;

	public Node(int value) 
	{
		this.value = value;
	}
}


