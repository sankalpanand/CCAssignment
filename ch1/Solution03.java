package Chapter1;
public class Solution03 {

	public static void main(String[] args) 
	{
		
		char[] arrInput = {'a','b','c',' ','d',' ','e',' ','f',' ',' ',' ',' ',' ',' '};
		String result = Urlify(arrInput, 6);	
		System.out.println(result);
	}

	public static String Urlify(char[] charInput, int trueLength)
	{		
		// Count number of spaces		
		int spaceCount = 0;
		for(int i=0; i<trueLength; i++) 
			if(charInput[i] == ' ') 
				spaceCount++;

		// Since each space is replaced by %20, so if we have n number of spaces, 
		// we will need 2n extra spaces in the char array
		int index = trueLength + 2 * spaceCount;

		// Since there is sufficient space at the back, we start filling up characters from the end
		// index tracks the last index in the bigger array
		// i tracks the index in the original smaller array
		// So we start walking backwards.
		for (int i = trueLength-1; i >= 0; i--) 
		{
			// Space char encountered, replace it with %20
			if(charInput[i] == ' ')
			{
				index--;
				charInput[index] = '0';
				index--;
				charInput[index] = '2';
				index--;
				charInput[index] = '%';
			}
			else // Normal character. Simply copy it.
			{
				index--;
				charInput[index] = charInput[i];
			}
		}		
		
		// Return the updated char array in form of String
		return String.valueOf(charInput);
	}
}
