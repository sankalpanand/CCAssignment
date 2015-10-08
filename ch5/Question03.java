package Chapter5_1;

public class Question03 
{
	public static void main(String[] args)
	{
		System.out.println(longestSequence(63));
	}
	
	public static int longestSequence(int n) 
	{
		int maxLen = 0;
		
		for (int i = 0; i < 32; i++) 
		{
			maxLen = Math.max(maxLen, longestSequence(n, i));
		}
		
		return maxLen;
	}
	
	public static int longestSequence(int n, int bitToSet) 
	{
		int max = 0;
		int counter = 0;
		
		// Start with zero, till the 32'th bit.
		for (int i = 0; i < 32; i++) 
		{			
			// increase counter only if the bit is set OR if it is the bit that we are flipping
			if (i == bitToSet || (n & (1 << i)) != 0) 
			{
				counter++;
				
				// Also update the max
				max = Math.max(counter, max);
			}
			
			// i'th bit is a zero, so the sequence just broke
			else 
			{
				counter = 0;
			}
		}
		
		// Return max if this particular bit is set
		return max;
	}
}
