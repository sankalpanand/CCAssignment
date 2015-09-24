package Chapter4;

public class Solution10 
{
	public static void main(String[] args) 
	{
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {3, 7, 10};



		TreeNode t1 = Solution02.createMinimalBST(array1, 0, array1.length - 1);
		TreeNode t2 = Solution02.createMinimalBST(array2, 0, array2.length - 1);

		if (containsTree(t1, t2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = Solution02.createMinimalBST(array1, 0, array1.length - 1);
		TreeNode t4 = Solution02.createMinimalBST(array3, 0, array3.length - 1);

		if (containsTree(t3, t4))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");

	}


	public static boolean containsTree(TreeNode t1, TreeNode t2) 
	{
		if (t2 == null)
			return true; // The empty tree is a subtree of every tree.

		if (t1 == null)
			return false; // big tree empty & subtree still not found.

		// If root data matches, check further.
		if (t1.data == t2.data) 
		{
			if (matchTree(t1,t2)) 
				return true;
		}

		// Root data did not match. First, Check in LST.		
		boolean ifT2InLeft = containsTree(t1.left, t2);

		// Then Check in RST.
		boolean ifT2InRight = containsTree(t1.right, t2);

		return (ifT2InLeft || ifT2InRight); 
	}


	/* It starts off by matching the data in the root. If it matches, then it recurses on both LSTs and then RSTs. If they also match, it returns true. */
	public static boolean matchTree(TreeNode r1, TreeNode r2) 
	{
		// Both trees traversed completely. So far everything matched. Nothing else left. Return true.
		if (r2 == null && r1 == null) 
			return true; 

		//  big tree empty & subtree still not found
		if (r1 == null || r2 == null) 
			return false; 

		// Data mismatch found, return false
		if (r1.data != r2.data) 
			return false;  

		// It means, data is matched. Now let's check thier LST and RST. If both match, then return true.
		return (matchTree(r1.left, r2.left) &&  matchTree(r1.right, r2.right));
	}
}