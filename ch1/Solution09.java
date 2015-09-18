package Chapter1;
public class Solution09 {

	public static void main(String[] args) 
	{
		Solution09 obj = new Solution09();
		System.out.println(obj.CheckRotation("waterbottle","erbottlewat"));
		System.out.println(obj.CheckRotation("camera","macera"));
		
	}

	// If we concatenate a word with itself, then the another word will definitely be a part of the concatenated string	
	public boolean CheckRotation(String str1, String str2) 
	{
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 == 0 || len2 == 0 || len1 != len2)
			return false;
		
		// Concatinate str1 with itself
		String concat = str1 + str1;
		
		// Check if str2 exists in the concatinated word - Just 1 call.
		return IsSubstring(concat, str2);
	}
	
	public boolean IsSubstring(String str1, String str2)
	{
		return str1.contains(str2);
	}

	// For display
	public void print(int[][] matrix)
	{
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
