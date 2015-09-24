package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution04 
{
	public static void main(String[] args) 
	{
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = Solution02.createMinimalBST(array, 0, array.length - 1);
		System.out.println(isBalanced(root));
	}


	public static boolean isBalanced(TreeNode root) 
	{
	    // height is a helper function which will return -1 in case of a disbalance.
	    // In other cases, it will return the height of the tree.
	    return height(root)!=-1;
	}
	public static int height(TreeNode node)
	{
	    // Base case if the leaf is hit
		if(node == null)
			return 0;
		
		// Cheeck the height of LST using recursive call
		int leftHt =  height(node.left);
		
		// If the left height returns -1, it means some node in LST is at disbalance.
		if(leftHt == -1) return -1;
		
		// Cheeck the right height using recursive call
		int rightHt = height(node.right);
		
		// If the right height returns -1, it means some node in RST is at disbalance.
		if(rightHt == -1) return -1;
		
		// If the difference between left and right > 1 then its a fail case. Return -1.
		if(Math.abs(rightHt-leftHt) > 1) return -1;
		
		// If the control fell through here, it means it's a pass case. Send the max of the left and right height.
		return 1 + Math.max(leftHt, rightHt);
	} 

}