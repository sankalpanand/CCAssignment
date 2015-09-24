package Chapter4;



public class Solution06 
{
	public static void main(String[] args) 
	{
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = Solution02.createMinimalBST(array, 0, array.length - 1);
		System.out.println(GetSuccessor(root, 3).data);
	}


	// Without Parent link
	public static TreeNode GetSuccessor(TreeNode root, int data)
	{
		// Search the node - O(h)
		TreeNode current = Find(root, data);
		if(current == null)
			return null;


		// Case 1: There is a RST
		if(current.right != null)		
			return FindMin(current.right);

		// Case 2: There is no RST
		TreeNode successor = null;
		TreeNode ancestor = root;

		// Start traversing from root to the current
		while(ancestor != current)
		{
			// If the current data < ancestor data, it means the current lies in the LST.			
			if(current.data < ancestor.data)
			{
				// In this case, the ancestor may be the successor as well.
				// We update the ancestor again if we go one level deep and there is a deeper ancestor for which the current lies in the LST
				successor = ancestor;

				// Move towards left
				ancestor = ancestor.left;
			}

			// current data > ancestor data, it means the current lies in the RST.
			else
			{
				// Move towards right
				ancestor = ancestor.right;
			}				
		}

		// When we come out of the while loop, the successor will either be null or it will be the address of some node.
		return successor;
	}

	//Function to find minimum in the tree
	public static TreeNode FindMin(TreeNode root)
	{
		if(root == null)
			return null;

		while(root.left != null)
		{
			root = root.left;
		}

		return root;		
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