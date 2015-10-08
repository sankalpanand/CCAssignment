package Chapter5_1;

public class Question04 {

	public static void main(String[] args) 
	{
		System.out.println(getNextLargest(12));
		System.out.println(getNextSmallest(12));
	}

	/*
	 * Step 1: Find out the last 0 that has some 1 to the right of it.
	 * Step 2: Count number of zeros and number of 1s (c1) to the right of it
	 * Step 3: Flip this 0 to 1. Now we have extra 1s. We have to reduce 1s somewhere else.
	 * Step 4: Convert all the digits following this new 1 to zero.
	 * Step 5: Add c1-1 ones from the right to the number.	 
	 * */
	public static int getNextLargest(int n) 
	{
		int c = n;
		int c0 = 0;
		int c1 = 0;

		// Count number of zeros from the end
		while (((c & 1) == 0) && (c != 0)) 
		{
			c0++;
			c = c >> 1;
		}

		// Count number of ones from the end
		while ((c & 1) == 1) 
		{
			c1++;
			c = c >> 1;
		}

		// If c is 0, then n is a sequence of 1s followed by a sequence of 0s. 
		// This is already the biggest number with c1 ones. Return error.
		if (c0 + c1 == 31 || c0 + c1 == 0) 
		{
			return -1;
		}

		// Position of the right most zero which has ones to the right of it
		int pos = c0 + c1;

		// Flip it to 1
		n = n | (1 << pos);


		// Clear all the bits to the right of pos
		int a = 1 << pos; // It will give all zeros except for 1 at position pos
		int b = a - 1; // It will give all zeros followed by pos ones
		int mask = ~b; // It will give all ones followed by pos zeros
		n = n & mask;


		// Add c1 - 1 ones to the right of it
		a = 1 << (c1 - 1); // It will give all zeros except for 1 at position (c1-1)
		b = a - 1; // It will give all zeros followed by c1-1 ones
		n = n | b;

		return n;
	}

	/*
	 * Step 1: Find out the last 1 that has some 0s to the right of it.
	 * Step 2: Count number of zeros (c0) and number of 1s (c1) to the right of it.
	 * Step 3: Flip this 1 to 0. Now we have extra 0s. We have to reduce 0s somewhere else.
	 * Step 4: Convert all the digits following this new 1 to zero.
	 * Step 5: Add c1+1 ones immediately to the right of pos.	 
	 * */
	public static int getNextSmallest(int n) 
	{
		int c = n;

		// Number of trailing ones
		int c1 = 0;

		// Size of the block of zeros to the immediate left of trailing ones
		int c0 = 0;

		// Count number of ones from the end
		while ((c & 1) == 1) 
		{
			c1++;
			c = c >> 1;
		}

		if (c == 0) 
		{
			return -1;
		}

		// Count number of zeros from the end
		while (((c & 1) == 0) && (c != 0)) 
		{
			c0++;
			c = c >> 1;
		}

		// Position of the right most one which has zeros to the right of it
		int pos = c0 + c1;

		// Clear all the bits to the right of pos
		int a = ~0;
		int b = a << (pos+1);
		n = n & b;

		// Insert c1 + 1 ones immediately to the right of p
		a = 1 << (c1 + 1); 
		b = a - 1;
		c = b << (c0 - 1);
		n = n | c;

		return n;
	}


}
