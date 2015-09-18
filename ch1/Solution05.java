package Chapter1;

public class Solution05 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Solution05 obj = new Solution05();
		String input = "aaaaabbbbbcdrfaaaaaaccccc";
		System.out.println(obj.StringCompression(input));
		input = "aaa";
		System.out.println(obj.StringCompression(input));
		input = "aa";
		System.out.println(obj.StringCompression(input));
	}


	public String StringCompression(String input) 
	{		
		StringBuffer compressedString = new StringBuffer();
		
		// Store the first character and increase the count to 1
		char last = input.charAt(0);
		int count = 1;
		
		// Start from the second character
		for (int i = 1; i < input.length(); i++) 
		{
			// If the character repeats itself
			if (input.charAt(i) == last) 
			{ 
				count++;
			} 
			
			// New character encountered! Update the StringBUilder
			else 
			{ 
				compressedString.append(last);
				compressedString.append(count);				
				last = input.charAt(i);
				count = 1;
			}
		}
		
		// Since, at last index the for loop will break. 
		// We need to treat the last character individually
		compressedString.append(last);
		compressedString.append(count);	
		
		if(compressedString.toString().length() == input.length()) 
			return input;
		
		return compressedString.toString();
	}



}
