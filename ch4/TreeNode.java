package Chapter4;

class TreeNode 
{
	public int data;      
	public TreeNode left;    
	public TreeNode right;
	public int size;
	public TreeNode next;

	public TreeNode(int data) 
	{
		this.data = data;
	}

	// This method inserts data in the subtrees of current node in an inorder fashion.
	public void insertInOrder(int val) 
	{
		if (val <= data) 
		{
			// If there is no child on the left, create one with the data
			if (left == null) 
				this.left = new TreeNode(val);

			// There is a child present, call this method on the child
			else 
				left.insertInOrder(val);
		}

		else 
		{
			// If there is no child on the right, create one with the data
			if (right == null) 
				this.right = new TreeNode(val);
			
			// There is a child present, call this method on the child
			else 
				right.insertInOrder(val);
		}
		size++;
	}
	
	// This method will return the i'th node in a deterministic manner.
	public TreeNode getIthNode(int i) 
	{
		int sizeOfLST = 0;
		
		if(this.left == null)
			sizeOfLST = 0;
		else
			sizeOfLST = left.size;
		
		// If random number is lesser than the size of LST, then we can get a random node from LST
		if (i < sizeOfLST) 
		{
			return left.getIthNode(i);
		} 
		
		// If random number is greater than the size of RST, then we can get a random node from RST
		else if (i > sizeOfLST) 
		{
			int sizeRST = i - (sizeOfLST + 1);
			return right.getIthNode(sizeRST);
		} 
		
		// If the random number is exactly equal to size of LST, return the root node 
		else 
		{
			return this;
		}
	}
}

class Tree
{
	TreeNode root = null;

	// This function creates a tree by inserting elements in order
	public void BuildTree(int value) 
	{
		// If the root is null, it means the tree is not yet created. Create one.
		if (root == null) 
		{
			root = new TreeNode(value);
		} 

		// Else, insert the value in an inorder fashion. 
		else 
		{
			root.insertInOrder(value);
		}
	}
}
