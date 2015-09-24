package Chapter4;

public class Solution12 
{
	public static void main(String[] args) 
	{
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};



		TreeNode root = Solution02.createMinimalBST(array1, 0, array1.length - 1);
		System.out.println(hasPathSum(root, 13));

	}


	public static boolean hasPathSum(TreeNode root, int sum) 
	{
		if(root == null) 
			return false;

		// Leaf case
		if(root.left == null && root.right == null && root.data == sum) 
			return true;

		boolean left = hasPathSum(root.left, sum - root.data);
		boolean right = hasPathSum(root.right, sum - root.data);

		return left || right;

	}
}