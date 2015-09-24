package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution05 
{
	public static void main(String[] args) 
	{
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = Solution02.createMinimalBST(array, 0, array.length - 1);
		System.out.println(isValidBST(root));
	}


	// The idea is to check the inorder traversal of the binary tree if it is sorted or not.
	static Stack<Integer> stack = new Stack<Integer>();

	public static boolean isValidBST(TreeNode root) 
	{
		// Base case
		if (root == null) 
		{
			return true;
		}

		// Store the inorder traversal in the stack
		inOrder(root);
		
		// Take out the top of stack. It will be the last value in the traversal
		int i = stack.pop();

		// Now start traveersing the inorder traversal from the end and keep comparing the adjacent values.
		while (!stack.isEmpty()) 
		{
			int j = stack.pop();
			
			// If the value towards the end is greater than its preceding value, its not balanced. Return false.
			if (i <= j) 
			{
				return false;
			}
			
			// Update i for the next iteration.
			i = j;
		}

		return true;
	}
	
	
	public static void inOrder(TreeNode root) 
	{
		if (root != null) 
		{
			inOrder(root.left);
			stack.push(root.data);
			inOrder(root.right);
		}
	}

	
	
}