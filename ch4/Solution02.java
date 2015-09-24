package Chapter4;

public class Solution02 
{
	public static void main(String[] args) 
	{
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = createMinimalBST(array, 0, array.length - 1);	

	}
	
	// To create a minimalistic tree, we need to pick the mid element of the sorted array.
	// Once we get mid, we have to make this mid as the root node.
	// Then we can send the left half to the same function recursive call and make it as Left Child
	// And send Right half to the same function recursive call and make it as Right Child
	public static TreeNode createMinimalBST(int arr[], int start, int end){
		if (end < start) 
		{
			return null;
		}
		
		// Take the mid element
		int mid = (start + end) / 2;
		
		// Make it a root
		TreeNode root = new TreeNode(arr[mid]);
		
		// Create left child by sending left half to the recursive call. It will give you the root of left half. 
		root.left = createMinimalBST(arr, start, mid - 1);
		
		// Create right child by sending right half to the recursive call. It will give you the root of right half.
		root.right = createMinimalBST(arr, mid + 1, end);
		
		// Return root
		return root;
	}
}
