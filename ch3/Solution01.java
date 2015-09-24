package Chapter3;


public class Solution01 {

	static int totalSize = 15;
	static int indivSize = 5;	
	static int[] arr = new int[totalSize];
	
	// Pointer to maintain Top of Stack
	int[] currPointer = {-1, -1, -1}; 
	
	// Array to maintain the capacity or each stack
	int[] capacity = {indivSize -1, indivSize * 2 -1, indivSize * 3 - 1};		
	
	// Array to maintain start of each stack
	int[] start = {0, indivSize, indivSize * 2};
	
	// Size of each stack
	int stackSize = 100; 
	
	// Size of total stack
	int[] buffer = new int[stackSize * 3]; 
	
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		Solution01 obj = new Solution01();
		obj.Question1_1();
	}
	
	/*Fixed division*/
	public void Question1_1() throws Exception
	{
		push(0, 1);
		push(0, 2);
		push(0, 3);
		push(0, 4);
		push(0, 5);
		
		// This will overflow Stack 0
		push(0, 20);
		
		
		push(1, 6);
		push(1, 7);
		push(1, 8);
		push(1, 9);
		push(1, 10);
		
		push(2, 11);
		push(2, 12);
		push(2, 13);
		push(2, 14);
		push(2, 15);
		
		pop(1);
		pop(1);
		pop(1);
		pop(1);
		pop(0);
		pop(1);
		
		// DisplayStack(arr);
		
	}
	
	// Partition array into three equall parts
	// Maintain start, capacity, current for each one of them.
	void push(int stackNum, int data) throws Exception
	{
		// Check for stack overflow
		if(currPointer[stackNum] == capacity[stackNum])
		{
			System.out.println("Out of space in array - " + stackNum);
			return;
		}
		
		System.out.println("Push(" + data + ") in " + (stackNum+1));
		
		// If the pointer for the given array is at starting point, it will take the pointer to start
		if(currPointer[stackNum] == -1)		
			currPointer[stackNum] = start[stackNum];
		
		// If there are elements present in the array, it will increment the pointer by 1
		else
			currPointer[stackNum]++;
		
		// Set the value on the updated pointer
		arr[currPointer[stackNum]] = data;
	}
	
	int pop(int stackNum) throws Exception
	{
		/* Check for stack overflow */
		if(currPointer[stackNum] == -1)
		{
			System.out.println("No element present in array - " + stackNum);
			return 0;
		}				
		
		// Extract the element which is popped
		int result = arr[currPointer[stackNum]];
		
		// Reset that location with default value
		arr[currPointer[stackNum]] = 0;
		
		// If there are no elements present in the array, move the pointer to -1
		if(currPointer[stackNum] == start[stackNum])
			currPointer[stackNum] = -1;
		
		// If there ARE elements present in the array, decreament the pointer
		else
			currPointer[stackNum]--;
		
		System.out.println("Pop(" + result + ") from " + stackNum );
		return result;
	}
	
	void DisplayStack(int[] arr)
	{
		for(int i : arr)
		{
			System.out.print(i + " ");
		}
	}

}
