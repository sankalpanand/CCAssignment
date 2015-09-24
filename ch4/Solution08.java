package Chapter4;

public class Solution08 
{
	public static void main(String[] args) 
	{
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = Solution02.createMinimalBST(array, 0, array.length - 1);
		TreeNode node2 = Find(root, 2);
		TreeNode node9 = Find(root, 9);
		System.out.println(lowestCommonAncestorR(root, node2, node9).data);
	}

	public static TreeNode lowestCommonAncestorR(TreeNode root, TreeNode p, TreeNode q) 
	{
		if(root == null || root == p || root == q)
		{
			return root;
		}

		TreeNode l = lowestCommonAncestorR(root.left,p,q);
		TreeNode r = lowestCommonAncestorR(root.right,p,q);

		// It means, something is there on the left AND something is there on the right as well. So, this root should be an ancestor.
		// E.g. [1,2,3] p=2, q=3
		if(l != null && r != null){
			return root;
		}

		// Control came here, means, both the nodes fall on one side only. 
		// So, one of l & r would have extracted the LCA by now.
		// Return whichever is not null among left and right.
		return l != null ? l:r;

	}


	//Function to find some data in the tree
	public static TreeNode Find(TreeNode root, int data)
	{
		if(root == null)
			return null;

		else if(root.data == data)
			return root;

		else if(root.data > data)
			return Find(root.left, data);

		else
			return Find(root.right, data);
	}
}