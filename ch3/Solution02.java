package Chapter3;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {

	// The idea is to implement Stack using an ArrayList. 
	// This ArrrayList will again have an Integer array of just two values.
	// First will be the number itself, second will be the minimum so far till the insertion of that number.
	// Thus, with every Push and Pop, we'll know what is the minimum at this point of time.
	List<Integer[]> stack = new ArrayList<Integer[]>();
	
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		Solution02 obj = new Solution02();
		obj.push(10);
		obj.push(11);
		obj.push(12);
		obj.push(9);
		obj.push(11);
		obj.push(1);
		obj.pop();
		obj.pop();
		obj.pop();
	}

	public void push(int x) 
	{
		int min = Integer.MIN_VALUE;

		// If there are some elements present in the stack
		if(stack.size() != 0)
		{
			// Take the minimum element stored with the top of stack
			int minSoFar = stack.get(stack.size() - 1)[1];
			
			// If new element is lesser than the minimum, then x becomes min so far
			if(x < minSoFar) 
				min = x;
			
			// If new element is not lesser than the minimum, min So far will remain the same
			else				
				min = minSoFar;

			// Form the array with this element and the minimum
			Integer[] n = {x, min};
			
			// PUSH it
			stack.add(n);
		}
		
		// If the stack is empty
		else
		{
			Integer[] n = {x, x};
			stack.add(n);
		}
		
		System.out.println("Push(" + x + ")\tMin->" + stack.get(stack.size() - 1)[1]);
	}

	public void pop() 
	{
		Integer[] num = stack.remove(stack.size() - 1);
		System.out.println("Pop(" + num[0] + ")\tMin->" + stack.get(stack.size() - 1)[1]);
	}

	public int top() 
	{
		return stack.get(stack.size() - 1)[0];
	}

	public int getMin() 
	{
		int minSoFar = stack.get(stack.size() - 1)[1];
		return minSoFar;
	}

}
