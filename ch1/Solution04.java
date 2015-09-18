package Chapter1;

public class Solution04 {

	public static void main(String[] args) 
	{
		String input = "Rats live on no evil star";
		String input2 = "Zeus was deified, saw Suez";
		Solution04 obj = new Solution04();
		Boolean result = obj.isPermutationOfPalindrome(input2);	
		System.out.println(result);
	}

	// Assumptions -
	// 1. I am doing case insensitive comparison. So, Tabat is a palindrome.
	// 2. I am not considering any special characters while checking palindrome.
	public boolean isPermutationOfPalindrome(String input)
	{
		// Convert string to lower case for string insensitive comparisons
		input = input.toLowerCase();

		// Create an array to check the occurrence of each letter
		int[] frequency = new int[26];
		int length=0;

		// Iterate through string, character by character. 
		for(char ch : input.toCharArray())
		{
			// Increase its count if its an alphabet.
			if(ch >= 'a' && ch <= 'z')
			{
				frequency[ch - 97]++;
				length++;
			}
		}

		// Count how many characters occurred just one time 
		int single = 0;
		for(int i=0; i<26; i++)
		{
			if((i >= 'a' - 97 && i <= 'z' - 97) && frequency[i] % 2 == 1)
			{
				single++;				
			}
		}
		
		// If length was even then there will be no character occurring just 1 time
		if(length % 2 == 0)
			return single == 0;
		
		// If length was odd then there can be just 1 character occurring 1 time
		else
			return single == 1;

	}

}
