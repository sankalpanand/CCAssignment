package Chapter1;
public class Solution01 {

	public static void main(String[] args) 
	{
		String input1 = "coding";
		String input2 = "bootcamp";
		Solution01 obj = new Solution01();
		System.out.println(input1 + " is Unique? " +  obj.isUnique(input1));
		System.out.println(input2 + " is Unique? " +  obj.isUnique(input2));
	}
	
	// Assumption: The input string contains only alphabets. 
	// We are considering lowercase and uppercase alike.
	public boolean isUnique(String input)
	{
		int length = input.length();
		input = input.toLowerCase();
		
		// Since we are asked not to use additional data structures, 
		// I will make use of 32 bits of an integer variable to store the states of 26 letters-
		// If a letter has occurred before, it will be 1 otherwise for a fresh occurrence, it will be 1.
		int marker = 0;
		
		// Iterate over the string
		for(int i=0; i<length; i++)
		{
			// Get the character we are going to process
			char ch = input.charAt(i);			
			
			// Get the index where that character should be stored in the 26 bits in integer.
			int indexOfChar = ch - 'a';
			
			// Generate a number with only the above index bit as 1, rest all 0.
			// We will shift 1 to left by the value of index.
			// a will be at 1, b will be at 10, c at 100, d at 1000 and so on.
			int bitAtChar = (1 << indexOfChar); 
			
			// Test if the marker bit at the index position is set or not by ANDing it with the generated number.
			// If it is already set, then this character is a duplicate one.
			if((marker & bitAtChar) > 0)
			{
				return false;
			}
			
			// If it is not set already, set it for the first time by ORing with the generated number.
			else
			{
				marker = (marker | bitAtChar);
			}						
		}
		
		// Control reached till here, it means false never executed.
		// So, the number should be unique. Return true.
		return true;
	}
}
