package Chapter1;

public class Solution02 {

	public static void main(String[] args) 
	{
		String input1 = "permutation";
		String input2 = "tationpermu";
		String input3 = "tatioopermu";
		Solution02 obj = new Solution02();
		System.out.println("Is permutation? " +  obj.checkPermutation(input1, input2));
		System.out.println("Is permutation? " +  obj.checkPermutation(input2, input3));
	}
	
	// Assumption: The input string can contains only ASCII char set. 
	public boolean checkPermutation(String str1, String str2)
	{
		int length1 = str1.length();
		int length2 = str2.length();
		
		// If length is not the same, then they can not be permutation of one another.
		if(length1 != length2)
			return false;
		
		// Take an integer array to maintain each letter's frequency
		int[] count = new int[256];
		
		// Increase the frequency for every occurrance.
		for(int i=0; i<length1; i++)
		{
			char ch = str1.charAt(i);
			count[ch]++;
		}
		
		// Decrease the frequency for every occurrence.
		// If the words are the permutations, then the count should be reduced to zero.
		for(int i=0; i<length2; i++)
		{
			char ch = str2.charAt(i);
			count[ch]--;
		}
		
		// If there is any index with a non zero count, 
		// it means there was some character in any of the two array which was not there in the second.
		// Return false for such case.
		for(int i=0; i<256; i++)
		{
			if(count[i] != 0)
				return false;
		}
		
		// Control reached till here, it means false never executed.
		// So, all numbers in the array were reduced to 0. Return true!
		return true;
	}
}
